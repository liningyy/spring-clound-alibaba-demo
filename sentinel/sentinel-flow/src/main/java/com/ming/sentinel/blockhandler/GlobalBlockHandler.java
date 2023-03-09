package com.ming.sentinel.blockhandler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ming.sentinel.dto.ResultDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 贺春明
 * @date 2023/3/8
 * 全局限流降级处理
 */

@Component
public class GlobalBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        ResultDTO<String> dto = new ResultDTO<>();
        if (e instanceof FlowException) { // 服务限流异常
            dto.setCode(10001);
            dto.setMessage("服务已限流");
        }else if(e instanceof DegradeException){ // 降级异常
            dto.setCode(10002);
            dto.setMessage("服务已熔断");
        }
        response.setContentType("application/json;charset=utf-8");
        String json = new ObjectMapper().writeValueAsString(dto);
        response.getWriter().println(json);
    }
}
