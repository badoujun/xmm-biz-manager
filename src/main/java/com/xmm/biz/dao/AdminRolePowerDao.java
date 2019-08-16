package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminRolePower;
import com.xmm.biz.pojo.AdminRolePowerExample;
import org.springframework.stereotype.Repository;

/**
 * AdminRolePowerDao继承基类
 */
@Repository
public interface AdminRolePowerDao extends MyBatisBaseDao<AdminRolePower, Long, AdminRolePowerExample> {
}