package com.ming.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author 贺春明
 * @date 2023/3/7
 * 自定义负载均衡器，装配随机的负载均衡算法
 * 注意：这个配置类不要添加@Configuration的注解
 * ，否则会导致在代理所有的Bean方法，会先装配负载均衡器，
 * 但是此时是没有服务调用的，所以获取的服务名为null
 */

@Slf4j
public class CustomLoadBalancerConfig {

    /**
     * 装配随机负载均衡策
     * 注意：默认是使用RoundRobinLoadBalancer(轮询策略)
     *
     * @param environment
     * @param loadBalancerClientFactory
     * @return
     */
    @Bean
    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
        // 获取当前需要负载均衡的服务名
        String serviceName = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        log.info("服务名：" + serviceName);
        // 给当前服务设置随机的负载均衡器
        return new RandomLoadBalancer(loadBalancerClientFactory
                .getLazyProvider(serviceName, ServiceInstanceListSupplier.class),
                serviceName);
    }
}
