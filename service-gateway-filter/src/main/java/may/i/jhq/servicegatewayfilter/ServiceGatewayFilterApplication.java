package may.i.jhq.servicegatewayfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceGatewayFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayFilterApplication.class, args);
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/customer/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addRequestHeader("X-Response-Default-Foo", "Default-Bar"))
                                .uri("http://httpbin.org:80/get")
                        .order(0).id("customer_filter_route")).build();
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
}
