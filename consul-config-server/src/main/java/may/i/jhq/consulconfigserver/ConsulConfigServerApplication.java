package may.i.jhq.consulconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigServerApplication.class, args);
    }

    @RestController
    @RefreshScope
    public class FooBarController {

        @Value("${foo.bar}")
        String fooBar;

        @GetMapping("/foo")
        public String getFooBar() {
            return fooBar;
        }
    }
}
