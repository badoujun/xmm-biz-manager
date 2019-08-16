package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminRole;
import com.xmm.biz.pojo.AdminRoleExample;
import org.springframework.stereotype.Repository;

/**
 * AdminRoleDao继承基类
 */
@Repository
public interface AdminRoleDao extends MyBatisBaseDao<AdminRole, Long, AdminRoleExample> {
}