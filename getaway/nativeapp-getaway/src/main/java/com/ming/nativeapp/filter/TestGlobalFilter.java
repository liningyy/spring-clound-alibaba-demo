package com.ming.nativeapp.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 贺春明
 * @date 2023/3/7
 *
 * 自定义全局过滤器，实现 GlobalFilter接口，
 * 还可以实现Ordered接口。用于设置多个全局过滤器执行的优先级别
 *
 * 需要按顺序执行过滤器，就需要实现 Ordered 接口
 */

@Component
@Slf4j
public class TestGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 全局过滤器核心处理方法
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("执行全局过滤器...");
        return chain.filter(exchange);
    }

    /**
     * 数据越小，优先级别越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
