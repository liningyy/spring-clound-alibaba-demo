package com.ming.cityservice;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan(basePackages = "com.ming.cityservice.dao")
@Slf4j
public class CityServiceApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(CityServiceApplication.class, args);
        while (true){
            // 当动态刷新配置时，配置中心的配置信息会自动更新到当前应用的内存中
            // 因此这里可以每间隔一秒钟从内存获取配置查看是否有变化
            /**
             * getEnvironment()获取当前环境
             */
            String userName = context.getEnvironment().getProperty("user.name");
            log.info("===>" + userName);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
