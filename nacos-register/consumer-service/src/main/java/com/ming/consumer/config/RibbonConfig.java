package com.ming.consumer.config;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 贺春明
 * @date 2023/3/1
 */

@Deprecated
//@Configuration
public class RibbonConfig {

    /**
     * 配置Ribbon的负载均衡策略，这里指定为随机策略
     * 注意：方法名一定要是 iRule
     * @return
     */
//    @Bean
//    public IRule iRule(){
//        return new RandomRule();
//    }
}
