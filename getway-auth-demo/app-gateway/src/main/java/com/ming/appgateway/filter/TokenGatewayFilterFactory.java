package com.ming.appgateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ming.appgateway.dto.ResultDto;
import com.ming.appgateway.util.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author 贺春明
 * @date 2023/3/7
 */

@Component
@Slf4j
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    /**
     * 请求头的name
     */
    private final static String HEADER = "Authorization";

    /**
     * token的前缀
     */
    private final static String TOKEN_PREFix = "Bearer ";

    public TokenGatewayFilterFactory() {
        super(TokenGatewayFilterFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("enable");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (config.getEnable()) {
                    log.info("进入过滤器！！！！！！！！！");
                    String token = exchange.getRequest().getHeaders().getFirst(HEADER);
                    log.info("token：" + token);
                    ServerHttpResponse response = exchange.getResponse();
                    response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                    if (token != null) {
                        String jwt = token.replace(TOKEN_PREFix, "");
                        try {
                            JwtUtils.verify(jwt);
                        } catch (SecurityException e) {
                            sendJsonResponse(response, "无效的签名");
                        } catch (MalformedJwtException e) {
                            sendJsonResponse(response, "无效的Token");
                        } catch (ExpiredJwtException e) {
                            sendJsonResponse(response, "Token已过期");
                        } catch (UnsupportedJwtException e) {
                            sendJsonResponse(response, "不支持的Token类型");
                        }
                    }else {
                        log.info("未登录！！！！");
                        return sendJsonResponse(response,"未登录，请重新登录");
                    }
                }
                return chain.filter(exchange);
            }
        };
    }

    public static class Config {
        private Boolean enable;

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }
    }

    private Mono<Void> sendJsonResponse(ServerHttpResponse response, String errorMsg) {
        try {
            ResultDto resultDto = new ResultDto();
            resultDto.setCode(HttpStatus.UNAUTHORIZED.value());
            resultDto.setMessage(errorMsg);
            ObjectMapper mapper = new ObjectMapper();
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response.writeWith(Mono.just(response.bufferFactory()
                    .wrap(mapper.writeValueAsBytes(resultDto))));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
