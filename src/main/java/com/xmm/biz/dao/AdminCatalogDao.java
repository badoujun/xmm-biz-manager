package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminCatalog;
import com.xmm.biz.pojo.AdminCatalogExample;
import org.springframework.stereotype.Repository;

/**
 * AdminCatalogDao继承基类
 */
@Repository
public interface AdminCatalogDao extends MyBatisBaseDao<AdminCatalog, Long, AdminCatalogExample> {
}