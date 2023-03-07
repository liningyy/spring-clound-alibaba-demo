package com.ming.nativeapp.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author 贺春明
 * @date 2023/3/7
 * 自定义局部过滤器，命名规则和路由规则类似
 * 1、类的命名：yml中filters配置的参数的名称 + GatewayFilterFactory
 * 2、继承AbstractGatewayFilterFactory，泛型指定Config内部类
 */

@Component
@Slf4j
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    public MyGatewayFilterFactory() {
        super(MyGatewayFilterFactory.Config.class);
    }

    /**
     * 将获取yml的参数值封装为list，并设置到Config的属性enable中
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("enable");
    }

    /**
     * 核心过滤器逻辑方法
     *
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(Config config) {
        log.info("自定义过滤器：" + config.getEnable());
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("执行Filter的Pre（预处理）阶段...");
                if (config.getEnable()) {
                    // 正确过滤逻辑 ...
                    log.info("启用了自定义过滤器，开始执行过滤逻辑...");
                }
                // 放行
                // return chain.filter(exchange);
                // 放行时，还可以在then方法中执行post（后置）阶段的逻辑
                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                    log.info("执行Filter的Post（后置）阶段...");
                }));
            }
        };
    }

    /**
     * 参数配置类，用于封装yml的参数值
     */
    public static class Config {
        private Boolean enable;

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }
    }
}
