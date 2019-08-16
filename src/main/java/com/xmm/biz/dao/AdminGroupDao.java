package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminGroup;
import com.xmm.biz.pojo.AdminGroupExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AdminGroupDao继承基类
 */
@Repository
public interface AdminGroupDao extends MyBatisBaseDao<AdminGroup, Long, AdminGroupExample> {

    AdminGroup findByUserId(@Param("id")long id);

    int findPersonNumOfGroup(List<Long> list);
}