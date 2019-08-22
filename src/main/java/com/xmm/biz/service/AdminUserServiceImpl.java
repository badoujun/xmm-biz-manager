package com.xmm.biz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmm.biz.dao.AdminGroupDao;
import com.xmm.biz.dao.AdminUserDao;
import com.xmm.biz.pojo.AdminGroup;
import com.xmm.biz.pojo.AdminUser;
import com.xmm.biz.pojo.AdminUserExample;
import com.xmm.biz.vo.result.AdminUserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserDao adminUserDao;

    @Autowired
    AdminGroupService adminGroupService;

    @Autowired
    AdminGroupDao adminGroupDao;

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

    @Override
    public PageInfo<AdminUserResult> findUsersByGroup(long groupId, int pageNum, int pageSize) {
        AdminGroup adminGroup = new AdminGroup();
        adminGroup.setId(groupId);
        List<AdminGroup> groups = adminGroupService.getGroupDown(adminGroup);
        List<Long> groupIds = new ArrayList<>();
        for(AdminGroup group : groups){
            groupIds.add(group.getId());
        }
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andGroupidIn(groupIds);
        PageHelper.startPage(pageNum, pageSize);//分页,start
//        List<AdminUser> list = adminUserDao.selectByExample(example);
        List<AdminUserResult> list = adminUserDao.findUserDataByExample(example);
        PageInfo<AdminUserResult> pageInfo = new PageInfo<>(list);//分页,end
        return pageInfo;
    }

    @Override
    public int add(AdminUser group) {
        return 0;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(AdminUser group) {
        return false;
    }
}
