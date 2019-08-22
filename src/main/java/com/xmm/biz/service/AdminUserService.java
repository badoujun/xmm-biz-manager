package com.xmm.biz.service;

import com.github.pagehelper.PageInfo;
import com.xmm.biz.pojo.AdminUser;
import com.xmm.biz.vo.result.AdminUserResult;

public interface AdminUserService {

    AdminUser findById(long userId);

    boolean checkUserPower(long userId, String powerEnum);

    PageInfo<AdminUserResult> findUsersByGroup(long groupId, int pageNum, int pageSize);

    int add(AdminUser group);

    boolean delete(long id);

    boolean update(AdminUser group);
}
