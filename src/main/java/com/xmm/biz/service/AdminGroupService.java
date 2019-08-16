package com.xmm.biz.service;

import com.xmm.biz.pojo.AdminGroup;
import com.xmm.biz.vo.result.GroupResult;

import java.util.List;

public interface AdminGroupService {

    List<GroupResult> findByUser(long userId);

    int add(AdminGroup group);

    boolean delete(long id);

    boolean update(AdminGroup group);
}
