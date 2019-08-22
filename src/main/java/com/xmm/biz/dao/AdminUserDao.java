package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminUser;
import com.xmm.biz.pojo.AdminUserExample;
import com.xmm.biz.vo.result.AdminUserResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AdminUserDao继承基类
 */
@Repository
public interface AdminUserDao extends MyBatisBaseDao<AdminUser, Long, AdminUserExample> {

    int checkUserPower(@Param("userId") long userId, @Param("powerEnum") String powerEnum);

    List<AdminUserResult> findUserDataByExample(AdminUserExample example);
}