package com.xmm.biz.service;

import com.xmm.biz.dao.AdminUserDao;
import com.xmm.biz.pojo.AdminUser;
import com.xmm.biz.pojo.AdminUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserDao adminUserDao;

    @Override
    public AdminUser findById(long userId) {
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userId);
        List<AdminUser> list = adminUserDao.selectByExample(example);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean checkUserPower(long userId, String powerEnum) {
        return adminUserDao.checkUserPower(userId, powerEnum) == 1;
    }
}
