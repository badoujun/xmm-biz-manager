package com.xmm.biz.vo.request;

import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "新增组织请求对象")
public class AdminGroupAddRequest extends BaseRequest implements RequestCheck{

    @ApiModelProperty(value = "组织名", required = true)
    private String groupName;

    @ApiModelProperty(value = "父级组织ID", required = true)
    private long parentId;

    @Override
    public void toRequestCheck() {
        if(groupName == null){
            throw new BaseException(ResultValueEnum.INPUT_GROUP_NAME_ERROR);
        }
        if(parentId < 1){
            throw new BaseException(ResultValueEnum.INPUT_GROUP_PARENTID_ERROR);
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
}
