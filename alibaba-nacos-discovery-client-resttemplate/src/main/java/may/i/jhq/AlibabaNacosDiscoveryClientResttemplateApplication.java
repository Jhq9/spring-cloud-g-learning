package may.i.jhq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryClientResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryClientResttemplateApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {
        @Autowired
        private RestTemplate restTemplate;

        @GetMapping("/test")
        public String test() {
            String result = restTemplate.getForObject("http://alibaba-nacos-discovery-server/hello?name=May", String.class);

            return "Return : " + result;
        }
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
