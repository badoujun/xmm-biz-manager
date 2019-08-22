package com.xmm.biz.service;

import com.xmm.biz.pojo.AdminGroup;
import com.xmm.biz.vo.result.GroupResult;

import java.util.List;

public interface AdminGroupService {

    List<GroupResult> findByUser(long userId);

    List<AdminGroup> getGroupDown(AdminGroup adminGroup);

    int add(AdminGroup group);

    boolean delete(long id);

    boolean update(AdminGroup group);

    /**
     * 判断操作的指定组织是否属于用户所属组织旗下
     */
    boolean isGroupInner(long userId, long groupId);
}
