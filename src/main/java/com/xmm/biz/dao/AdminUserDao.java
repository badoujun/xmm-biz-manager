package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminUser;
import com.xmm.biz.pojo.AdminUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * AdminUserDao继承基类
 */
@Repository
public interface AdminUserDao extends MyBatisBaseDao<AdminUser, Long, AdminUserExample> {

    int checkUserPower(@Param("userId") long userId, @Param("powerEnum") String powerEnum);

}