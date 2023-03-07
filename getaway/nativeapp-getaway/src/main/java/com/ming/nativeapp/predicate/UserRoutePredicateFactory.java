package com.ming.nativeapp.predicate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 贺春明
 * @date 2023/3/6
 * <p>
 * 自定义路由断言工厂，用于创建特定的路由规则
 * 注意：
 * 1、类名必须是Xxx开头标识路由规则的名称，Xxx应对应配置文件中的predicate参数的名称
 * predicate:
 * - User=1，2，3
 * 2、类名必须是一RoutePredicateFactory结尾
 * 例如这里自定义的路由规则类名为：UserRoutePredicateFactory
 * 3、必须继承 AbstractRoutePredicateFactory，泛型参数是一个Config内部类
 */

@Component
@Slf4j
public class UserRoutePredicateFactory extends AbstractRoutePredicateFactory<UserRoutePredicateFactory.Config> {

    public UserRoutePredicateFactory() {
        super(Config.class);
    }

    /**
     * 当需要将配置文件中的多个参数映射到Config设置类中的List属性时，
     * 重写此方法并返回 GATHER_LIST类型的ShortcutType，这样才能映射
     * List 类型的参数
     */
    @Override
    public ShortcutType shortcutType() {
        return ShortcutType.GATHER_LIST;
    }

    /**
     * 读取yml的规则信息，配置到Config内部类的userId中
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        // 转换为Config内部声明userId的list集合
        return Arrays.asList("userId");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        log.info("list集合个数 "+config.getUserId().size());
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                // 接收请求路径传过来的uid
                String path = serverWebExchange.getRequest().getURI().getPath();
                String[] uri = path.split("/");
                String uid = uri[uri.length-1];
                log.info("用户ID：" + uid);
                if (uid != null && config.getUserId().contains(uid)) {
                    return true;
                }
                return false;
            }
        };
    }

    /**
     * 提供一个静态的内部类，用来设置断言规则的参数
     *
     * @return
     */
    public static class Config {
        private List<String> userId = new ArrayList<>();

        public List<String> getUserId() {
            return userId;
        }

        public void setUserId(List<String> userId) {
            this.userId = userId;
        }
    }
}
