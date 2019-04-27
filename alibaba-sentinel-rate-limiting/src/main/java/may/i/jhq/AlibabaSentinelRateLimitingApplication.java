package may.i.jhq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AlibabaSentinelRateLimitingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelRateLimitingApplication.class, args);
    }

    @Slf4j
    @RestController
    public static class TestController {

        @GetMapping("/hello")
        public String hello() {
            return "May i";
        }
    }
}
