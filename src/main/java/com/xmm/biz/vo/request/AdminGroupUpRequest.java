package com.xmm.biz.vo.request;

import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "修改组织请求对象")
public class AdminGroupUpRequest extends AdminIdRequest implements RequestCheck{

    @ApiModelProperty(value = "组织名", required = true)
    private String groupName;

    @ApiModelProperty(value = "父级组织ID", required = true)
    private long parentId;

    @ApiModelProperty(value = "排序", required = true)
    private int sort;

    @ApiModelProperty(value = "状态,1-正常,2-禁用", required = true)
    private int state;

    @Override
    public void toRequestCheck() {
        if(groupName == null){
            throw new BaseException(ResultValueEnum.INPUT_GROUP_NAME_ERROR);
        }
        if(parentId < 1){
            throw new BaseException(ResultValueEnum.INPUT_GROUP_PARENTID_ERROR);
        }
        if(sort < 1){
            throw new BaseException(ResultValueEnum.INPUT_SORT_ERROR);
        }
        if(state != 1 && state != 2){
            throw new BaseException(ResultValueEnum.INPUT_STATE_ERROR);
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
