package com.xmm.biz.vo.request;

import com.xmm.biz.constant.ResultValueEnum;

/**
 * 请求验证接口
 */
public interface RequestCheck {

    /**
     * 检查请求参数是否符合接口规范
     * @return ResultValueEnum
     */
    void toRequestCheck();
}
