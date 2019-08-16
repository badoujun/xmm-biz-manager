package com.xmm.biz.controller;

import com.xmm.biz.service.AdminService;
import com.xmm.biz.vo.request.AdminLoginRequest;
import com.xmm.biz.vo.request.BaseRequest;
import com.xmm.biz.vo.result.AdminDataResult;
import com.xmm.biz.vo.result.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
@Api(tags = "管理相关")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(name = "后台登录", value = "/login")
    @ResponseBody
    @ApiOperation("后台登录")
    public BaseResult<AdminDataResult> adminLogin(AdminLoginRequest req){
        req.toRequestCheck();
        BaseResult<AdminDataResult> result = BaseResult.newInstance();
        AdminDataResult data = adminService.adminLogin(req.getUsername(), req.getPwd());
        result.setData(data);
        return result;
    }

}
