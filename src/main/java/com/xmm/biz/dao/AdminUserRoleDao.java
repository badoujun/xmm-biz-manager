package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminUserRole;
import com.xmm.biz.pojo.AdminUserRoleExample;
import org.springframework.stereotype.Repository;

/**
 * AdminUserRoleDao继承基类
 */
@Repository
public interface AdminUserRoleDao extends MyBatisBaseDao<AdminUserRole, Long, AdminUserRoleExample> {
}