package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminMenu;
import com.xmm.biz.pojo.AdminMenuExample;
import org.springframework.stereotype.Repository;

/**
 * AdminMenuDao继承基类
 */
@Repository
public interface AdminMenuDao extends MyBatisBaseDao<AdminMenu, Long, AdminMenuExample> {
}