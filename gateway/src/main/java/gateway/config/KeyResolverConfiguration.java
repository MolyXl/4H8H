package gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author MaZhuli
 */
@Configuration
public class KeyResolverConfiguration {
    @Bean(value = "pathKeyResolver")
    public KeyResolver pathKeyResolver(){
        return exchange -> {
            System.out.println("我草");
            return Mono.just(exchange.getRequest().getPath().toString());
            //return Mono.just(exchange.getRequest().getQueryParams().toString());
            //return Mono.just(exchange.getRequest().getRemoteAddress().toString());
        };
    }
}
