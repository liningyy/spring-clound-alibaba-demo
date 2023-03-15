package com.ming.sentinel.persistence.blockhandler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ming.sentinel.persistence.dto.ResultDto;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 贺春明
 * @date 2023/3/10
 */

@Component
public class GlobalBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        ResultDto<String> dto = new ResultDto<>();
        if (e instanceof FlowException){
            dto.setCode(10005);
            dto.setMessage("服务已限流");
        }else if(e instanceof DegradeException){
            dto.setCode(10002);
            dto.setMessage("服务熔断");
        }else {
            dto.setCode(500);
            dto.setMessage("服务内部异常");
        }
        httpServletResponse.setContentType("application/json;charset=utf-8");
        String json = new ObjectMapper().writeValueAsString(dto);
        httpServletResponse.getWriter().println(json);
    }
}
