package com.ming.sentinel.api;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ming.sentinel.blockhandler.MyBlockHandler;
import com.ming.sentinel.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author 贺春明
 * @date 2023/3/8
 */

@RestController
@Slf4j
public class DemoController {

    /**
     * 使用@SentinelResource注解自定义资源的名称和限流的异常处理
     * value属性：指定资源的名称，会同步到控制台
     * blockHandler属性：用于指定限流后需要处理的方法名
     * blockHandlerClass属性用于指定限流降级的处理类
     *
     * @return
     * @SentinelResource可以根据不同的资源请求设置不同的限流规则， 如果所有的规则都是一样的话，则可以定义一个全局的限流处理方法即可
     */
    @GetMapping("/say/{name}")
    /*@SentinelResource(value = "say",
            blockHandlerClass = MyBlockHandler.class,
            blockHandler = "flowHandler")*/
    public ResultDTO<String> say(@PathVariable("name") String name) throws InterruptedException {
        ResultDTO dto = new ResultDTO();
        dto.setCode(200);
        dto.setMessage("hello" + name);
        TimeUnit.SECONDS.sleep(10);
        return dto;
    }

    /**
     * 不停的产生异常，需要进行熔断。
     * 不熔断会导致上游服务或上上游服务不可用
     *
     * @return
     */
    @GetMapping("/degrade")
    public ResultDTO<String> degrade() throws InterruptedException {
        ResultDTO<String> dto = new ResultDTO<>();
        dto.setCode(200);
        // 睡眠2秒模拟慢调用(处理时间长)
        TimeUnit.SECONDS.sleep(2);
        return dto;
    }

    /**
     * 限流后的处理方法，方法返回值必须和资源请求方法保持一致，
     * 且方法必须声明 BlockException 参数
     *
     * @param e
     * @return
     */
    /*public String flowHandler(BlockException e) {
        log.info(e.getMessage());
        return "触发了限流规则";
    }*/
}
