package com.example.api_gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class RequestLoggingFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        logger.info("Incoming request URI: {}", exchange.getRequest().getURI());
        logger.info("Request Method: {}", exchange.getRequest().getMethod());
        logger.info("Request Headers:");

        exchange.getRequest().getHeaders().forEach((key, values) ->
                logger.info("{} : {}", key, values)
        );

        return chain.filter(exchange);
    }
}
