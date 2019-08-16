package com.xmm.biz.util;

import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import com.xmm.biz.service.AdminGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 权限工具类
 */
@Component
public class PowerUtil {

    @Autowired
    private AdminGroupService adminGroupService;

    /**
     * 判断操作的指定组织是否属于用户所属组织旗下
     */
    public void checkUserGroupAndUseGroup(long userId, long groupId){
        boolean flag = adminGroupService.isGroupInner(userId, groupId);
        if(!flag){
            throw new BaseException(ResultValueEnum.SYS_USER_NOT_HAVE_POWER);
        }
    }
}
