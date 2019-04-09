package may.i.jhq.serviceribbonhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class HelloService {

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String  hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    private String hiError(String name) {
        return "hi" + name + ",sorry,error!";
    }
}
