package com.xmm.biz.service.impl;

import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import com.xmm.biz.dao.AdminGroupDao;
import com.xmm.biz.dao.AdminRoleDao;
import com.xmm.biz.dao.AdminUserDao;
import com.xmm.biz.pojo.AdminGroup;
import com.xmm.biz.pojo.AdminGroupExample;
import com.xmm.biz.pojo.AdminRoleExample;
import com.xmm.biz.pojo.AdminUser;
import com.xmm.biz.service.AdminGroupService;
import com.xmm.biz.vo.result.GroupResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminGroupServiceImpl implements AdminGroupService {

    @Autowired
    AdminGroupDao adminGroupDao;

    @Autowired
    AdminUserDao adminUserDao;

    @Autowired
    AdminRoleDao adminRoleDao;

    @Override
    public List<GroupResult> findByUser(long userId) {
        List<GroupResult> list = new ArrayList<>();
        AdminGroup adminGroup = adminGroupDao.findByUserId(userId);
        List<AdminGroup> groups = getGroupDown(adminGroup);
        for(AdminGroup group : groups){
            GroupResult obj = new GroupResult();
            obj.setId(group.getId());
            obj.setGroupname(group.getGroupname());
            obj.setParentid(group.getParentid());
            obj.setSort(group.getSort());
            obj.setState(group.getState());
            list.add(obj);
        }
        return list;
    }

    @Override
    public List<AdminGroup> getGroupDown(AdminGroup adminGroup){
        List<AdminGroup> list = new ArrayList<>();
        list.add(adminGroup);
        List<Long> parentIds = new ArrayList<>();
        parentIds.add(adminGroup.getId());
        do {
            AdminGroupExample example = new AdminGroupExample();
            example.setOrderByClause("parentId,sort");
            AdminGroupExample.Criteria criteria = example.createCriteria();
            criteria.andParentidIn(parentIds);
            List<AdminGroup> groups = adminGroupDao.selectByExample(example);
            parentIds = new ArrayList<>();
            for(AdminGroup group : groups){
                parentIds.add(group.getId());
                list.add(group);
            }
        }while (parentIds.size() > 0);
        return list;
    }

    @Override
    public int add(AdminGroup group) {
        if(group.getSort() == null){
            AdminGroupExample example = new AdminGroupExample();
            example.setOrderByClause("sort desc");
            AdminGroupExample.Criteria criteria = example.createCriteria();
            criteria.andParentidEqualTo(group.getParentid());
            List<AdminGroup> groups = adminGroupDao.selectByExample(example);
            group.setSort(groups.size() > 0 ? Integer.valueOf(groups.get(0).getSort() + 1).byteValue() : 1);
        }
        return adminGroupDao.insertSelective(group);
    }

    @Override
    public boolean delete(long id) {
        AdminGroup group = new AdminGroup();
        group.setId(id);
        List<AdminGroup> list = getGroupDown(group);
        List<Long> groupIds = new ArrayList<>();
        for(AdminGroup item : list){
            groupIds.add(item.getId());
        }
        int personNum = adminGroupDao.findPersonNumOfGroup(groupIds);
        if(personNum == 0){
            AdminRoleExample roleExample = new AdminRoleExample();
            AdminRoleExample.Criteria roleCriteria = roleExample.createCriteria();
            roleCriteria.andGroupidIn(groupIds);
            adminRoleDao.deleteByExample(roleExample);
            AdminGroupExample groupExample = new AdminGroupExample();
            AdminGroupExample.Criteria groupCriteria = groupExample.createCriteria();
            groupCriteria.andIdIn(groupIds);
            int row = adminGroupDao.deleteByExample(groupExample);
            return row == groupIds.size() ? true : false;
        }else{
            throw new BaseException(ResultValueEnum.OTHER_GROUP_HAVE_PERSON);
        }
    }

    @Override
    public boolean update(AdminGroup group) {
        boolean flag = false;
        AdminGroup oldGroup = adminGroupDao.selectByPrimaryKey(group.getId());
        int offset = group.getSort() - oldGroup.getSort();
        if(offset != 0){
            flag = displaceGroupSort(oldGroup, group.getSort(), group.getUpdator());
        }else{
            flag = adminGroupDao.updateByPrimaryKeySelective(group) == 1;
        }
        return flag;
    }

    private boolean displaceGroupSort(AdminGroup group, Byte sort, String updator){
        AdminGroupExample example = new AdminGroupExample();
        AdminGroupExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(group.getParentid());
        criteria.andSortEqualTo(sort);
        AdminGroup record1 = new AdminGroup();
        record1.setSort(group.getSort());
        record1.setUpdator(updator);
        int row1 = adminGroupDao.updateByExampleSelective(record1, example);
        AdminGroup record2 = new AdminGroup();
        record2.setId(group.getId());
        record2.setSort(sort);
        record2.setUpdator(updator);
        int row2 = adminGroupDao.updateByPrimaryKeySelective(record2);
        return row1 == row2 && row1 > 0;
    }

    @Override
    public boolean isGroupInner(long userId, long groupId) {
        boolean flag = false;
        AdminUser user = adminUserDao.selectByPrimaryKey(userId);
        long myGroupId = user.getGroupid();
        long childId = groupId;
        if(user.getGroupid().equals(groupId)){
            flag = true;
        }else{//向上追溯组织
            while(true){
                AdminGroup group = adminGroupDao.selectByPrimaryKey(childId);
                if(group.getParentid().equals(myGroupId)){
                    flag = true;
                    break;
                }else if(group.getParentid().equals(Integer.valueOf(0).longValue())){
                    break;
                }else{
                    childId = group.getParentid();
                }
            }
        }
        return flag;
    }
}
