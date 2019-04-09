package may.i.jhq.servicegatewayfilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//全局的Filter
public class TokenFilter implements GlobalFilter, Ordered {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isEmpty(token)) {
            LOGGER.info("Token is empty");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
