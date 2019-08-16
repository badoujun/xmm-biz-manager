package com.xmm.biz.service;

import com.xmm.biz.pojo.AdminUser;

public interface AdminUserService {

    AdminUser findById(long userId);

    boolean checkUserPower(long userId, String powerEnum);
}
