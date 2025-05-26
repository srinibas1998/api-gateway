package com.example.api_gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import reactor.core.publisher.Mono;

@Configuration
public class LoggingGlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingGlobalFilter.class);

    @Bean
    public GlobalFilter logRequestFilter() {
        return (exchange, chain) -> {
            logger.info("Incoming Request: method = {}, path = {}",
                    exchange.getRequest().getMethod(),
                    exchange.getRequest().getURI().getPath());

            return chain.filter(exchange).then(Mono.fromRunnable(() ->
                    logger.info("Outgoing Response: status = {}",
                            exchange.getResponse().getStatusCode())
            ));
        };
    }
}
