package com.xmm.biz.interceptor;

import com.alibaba.fastjson.JSON;
import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import com.xmm.biz.vo.result.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常拦截器
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public String baseException(BaseException ex) {
        BaseResult<String> result = BaseResult.newInstance((ResultValueEnum) ex.getBizExceptionEnum());
        return JSON.toJSONString(result);
    }
}
