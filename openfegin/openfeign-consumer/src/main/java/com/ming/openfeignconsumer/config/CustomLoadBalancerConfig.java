package com.ming.openfeignconsumer.config;

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
 */

@Slf4j
public class CustomLoadBalancerConfig{
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
