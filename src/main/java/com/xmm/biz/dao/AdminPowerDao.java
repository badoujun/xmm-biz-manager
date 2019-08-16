package com.xmm.biz.dao;

import com.xmm.biz.pojo.AdminPower;
import com.xmm.biz.pojo.AdminPowerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AdminPowerDao继承基类
 */
@Repository
public interface AdminPowerDao extends MyBatisBaseDao<AdminPower, Long, AdminPowerExample> {

    List<AdminPower> findByUser(@Param("userId")long userId);

}