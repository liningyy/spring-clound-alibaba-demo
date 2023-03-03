package com.ming.openfeignconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 贺春明
 * @date 2023/3/2
 */

@Configuration
public class RibbonConfig {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
