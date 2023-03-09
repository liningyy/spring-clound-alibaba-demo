package com.ming.appgateway.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 贺春明
 * @date 2023/3/7
 * jwt生成类
 */

@Slf4j
public class JwtUtils {

    private final static String KEY = "auth-user";

    private final static String ISS = "com.ming";

    /**
     * 用于创建token
     *
     * @param body 数据载体
     * @param ttl  超时时间
     * @return
     */
    public static String createToken(Map<String, Object> body, Long ttl) {
        JwtBuilder builder = Jwts.builder()
                // 设置已ES256加密方式进行加密
                .signWith(SignatureAlgorithm.HS512, KEY)
                // 设置唯一编号
                .setId(UUID.randomUUID().toString())
                // 设置签发机构
                .setIssuer(ISS)
                // 设置载体
                .setClaims(body)
                // 设置主题
                .setSubject("JWT AUTH")
                // 设置签发时间
                .setIssuedAt(new Date());
        // 设置 jwt 过期时间
        if (ttl > 0) {
            builder.setExpiration(getExpDate(ttl));
        }
        return builder.compact();
    }

    /**
     * 通过键获取token的载体数据
     * @param token
     * @param name 键
     * @param type 类型
     * @return
     * @param <T>
     */
    public static <T> T getPayLoad(String token, String name, Class<T> type) {
        return Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody()
                .get(name, type);
    }

    /**
     * 验证token是否有效
     * @param token
     */
    public static void verify(String token){
        Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
    }


    /**
     * 设置过期时间
     *
     * @param ttl
     * @return
     */
    private static Date getExpDate(Long ttl) {
        Date date = new Date(System.currentTimeMillis() + ttl);
        log.info("过期时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        return date;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        System.out.println(createToken(map, 10000L));
    }
}
