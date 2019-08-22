package com.xmm.biz.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "分页通用请求对象")
public class AdminPageRequest extends BaseRequest implements RequestCheck{

    @ApiModelProperty(value = "页码", required = true)
    private int pageNum;

    @ApiModelProperty(value = "每页条数", required = true)
    private int pageSize;

    @Override
    public void toRequestCheck() {
        if(pageNum < 1){
            pageNum = 1;
        }
        if(pageSize < 1){
            pageSize = 10;
        }
        if(pageSize > 100){
            pageSize = 100;
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
