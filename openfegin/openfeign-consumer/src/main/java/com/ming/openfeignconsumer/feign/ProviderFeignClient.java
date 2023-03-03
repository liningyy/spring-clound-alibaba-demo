package com.ming.openfeignconsumer.feign;

import com.ming.openfeignconsumer.dto.ResultDto;
import com.ming.openfeignconsumer.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 贺春明
 * @date 2023/3/2
 * 命名：被调用方服务名称+FeignClient
 * @FeignClient注解：
 *  name属性：指定被调用方的服务名，应为OpenClient要根据这个名字到Nocas注册中心查找服务
 */

@FeignClient(name = "openfeign-provider" )
public interface ProviderFeignClient {

    /**
     * 声明于openfeign-provider服务相同的请求映射。
     * 注意：openfeign在传参时如果是普通参数使用@RequestParam注解指定参数，
     * 如果是对象则使用@ReqeustBody注解，如果是路径参数则使用@PathVariable注解
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    ResultDto<UserDto> findUser(@PathVariable("id") int id);
}
