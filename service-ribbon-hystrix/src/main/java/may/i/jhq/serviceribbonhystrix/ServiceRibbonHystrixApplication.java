package may.i.jhq.serviceribbonhystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableHystrix
public class ServiceRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonHystrixApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate () {
        return new RestTemplate();
    }

    @Autowired
    private HelloService helloService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
