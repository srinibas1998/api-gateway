package com.example.api_gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
//
//@Configuration
//public class GlobalCorsFilter {
//
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public GlobalFilter corsFilter() {
//        return (exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//
//            HttpHeaders headers = exchange.getResponse().getHeaders();
//            headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
//            headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//            headers.add("Access-Control-Allow-Headers", "*");
//            headers.add("Access-Control-Allow-Credentials", "true");
//
//            if (request.getMethod() == HttpMethod.OPTIONS) {
//                exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.OK);
//                return Mono.empty();
//            }
//
//            return chain.filter(exchange);
//        };
//    }
//}
