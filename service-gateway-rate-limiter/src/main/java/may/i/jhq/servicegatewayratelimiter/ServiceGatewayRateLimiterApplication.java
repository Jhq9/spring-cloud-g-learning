package may.i.jhq.servicegatewayratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceGatewayRateLimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayRateLimiterApplication.class, args);
    }

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
}
