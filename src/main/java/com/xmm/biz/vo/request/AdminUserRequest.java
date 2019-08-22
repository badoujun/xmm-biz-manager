package com.xmm.biz.vo.request;

import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户集合请求对象")
public class AdminUserRequest extends AdminPageRequest implements RequestCheck{

    @ApiModelProperty(value = "ID", required = true)
    private long id;

    @Override
    public void toRequestCheck() {
        super.toRequestCheck();
        if(id < 1){
            throw new BaseException(ResultValueEnum.INPUT_ID_ERROR);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
