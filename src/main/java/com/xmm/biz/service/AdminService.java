package com.xmm.biz.service;

import com.xmm.biz.vo.model.CatalogVo;
import com.xmm.biz.vo.result.AdminDataResult;

import java.util.List;

public interface AdminService {

    AdminDataResult adminLogin(String username, String password);

    List<CatalogVo> getCatalogsByUser(long userId);
}
