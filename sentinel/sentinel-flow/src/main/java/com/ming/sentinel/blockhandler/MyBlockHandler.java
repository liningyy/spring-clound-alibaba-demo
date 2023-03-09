package com.ming.sentinel.blockhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.ming.sentinel.dto.ResultDTO;

/**
 * @author 贺春明
 * @date 2023/3/8
 */

public class MyBlockHandler {

    public static ResultDTO<String> flowHandler(String name, BlockException e) {

        ResultDTO<String> dto = new ResultDTO();
        // 判断是限流异常还是降级异常
        if (e instanceof FlowException) {
            dto.setCode(10001);
            dto.setMessage("服务已限流");
        }
        return dto;
    }
}
