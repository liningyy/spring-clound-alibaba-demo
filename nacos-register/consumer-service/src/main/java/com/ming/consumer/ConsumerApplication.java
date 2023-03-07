package com.ming.consumer;

import com.ming.consumer.config.CustomLoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

/**
 * @author 贺春明
 * @date 2023/3/1
 */

@SpringBootApplication
/**
 * 当需要自定义负载均衡策略时，可以结合@LoadBalancerClients以及
 * @@LoadBalancerClient子注解来给服务设置相关的负载均衡策略
 * 例如：
 * @LoadBalancerClients({
 *         @LoadBalancerClient(name = "provider-service",configuration = CustomLoadBalancerConfig.class),
 *         @LoadBalancerClient(name = "xxx-service",configuration = CustomLoadBalancerConfig.class)
 * })
 * name属性指定需要负载均衡的服务名称
 * configuration属性指定自定义的负载均衡配置类
 */
/*@LoadBalancerClients({
        @LoadBalancerClient(name = "provider-service",configuration = CustomLoadBalancerConfig.class)
})*/
/**
 * 也可以直接在@LoadBalancerClients注解的defaultConfiguration属性中
 * 覆盖默认的负载均衡策略
 * 默认全部服务都是用随机的负载均衡策略
 */
@LoadBalancerClients(defaultConfiguration = CustomLoadBalancerConfig.class)
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
