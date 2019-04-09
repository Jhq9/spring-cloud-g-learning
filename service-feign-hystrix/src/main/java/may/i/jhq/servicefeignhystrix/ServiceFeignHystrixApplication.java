package may.i.jhq.servicefeignhystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@RestController
public class ServiceFeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignHystrixApplication.class, args);
    }

    @Autowired
    private HelloService helloService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name) {
        return helloService.sayHiFromClientOne(name);
    }
}
