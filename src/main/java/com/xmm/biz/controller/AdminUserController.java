package com.xmm.biz.controller;

import com.github.pagehelper.PageInfo;
import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import com.xmm.biz.pojo.AdminUser;
import com.xmm.biz.service.AdminUserService;
import com.xmm.biz.target.UserLoginToken;
import com.xmm.biz.util.PowerUtil;
import com.xmm.biz.vo.request.*;
import com.xmm.biz.vo.result.AdminPageResult;
import com.xmm.biz.vo.result.AdminUserResult;
import com.xmm.biz.vo.result.BaseResult;
import com.xmm.biz.vo.result.GroupResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "管理用户相关")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    PowerUtil powerUtil;

    @RequestMapping(name = "用户列表", value = "/find")
    @ResponseBody
    @ApiOperation("用户列表")
    @UserLoginToken(powerName = "user_sel")
    public BaseResult<AdminPageResult<AdminUserResult>> findUser(AdminUserRequest req){
        req.toRequestCheck();
        powerUtil.checkUserGroupAndUseGroup(req.getUserId(), req.getId());
        BaseResult<AdminPageResult<AdminUserResult>> result = BaseResult.newInstance();
        PageInfo<AdminUserResult> pageInfo = adminUserService.findUsersByGroup(req.getId(), req.getPageNum(), req.getPageSize());
        AdminPageResult<AdminUserResult> pageResult = new AdminPageResult<>();
        pageResult.setList(pageInfo.getList());
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setPages(pageInfo.getPages());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setPrePage(pageInfo.getPrePage());
        pageResult.setNextPage(pageInfo.getNextPage());
        result.setData(pageResult);
        return result;
    }

    @RequestMapping(name = "新增用户", value = "/add")
    @ResponseBody
    @ApiOperation("新增用户")
    @UserLoginToken(powerName = "user_add")
    public BaseResult<GroupResult> addUser(AdminGroupAddRequest req){
        req.toRequestCheck();
        powerUtil.checkUserGroupAndUseGroup(req.getUserId(), req.getParentId());
        AdminUser user = new AdminUser();
        int row = adminUserService.add(user);
        if(row == 1){
            GroupResult groupResult = new GroupResult();
            groupResult.setId(user.getId());
            BaseResult<GroupResult> result = BaseResult.newInstance();
            result.setData(groupResult);
            return result;
        }else{
            throw new BaseException(ResultValueEnum.OTHER_COMMON_MODIFY_ERROR);
        }
    }

    @RequestMapping(name = "删除用户", value = "/delete")
    @ResponseBody
    @ApiOperation("删除用户")
    @UserLoginToken(powerName = "user_del")
    public BaseResult<String> deleteUser(AdminIdRequest req){
        req.toRequestCheck();
        powerUtil.checkUserGroupAndUseGroup(req.getUserId(), req.getId());
        boolean flag = adminUserService.delete(req.getId());
        if(flag){
            BaseResult<String> result = BaseResult.newInstance();
            return result;
        }else{
            throw new BaseException(ResultValueEnum.OTHER_COMMON_MODIFY_ERROR);
        }
    }

    @RequestMapping(name = "修改用户", value = "/update")
    @ResponseBody
    @ApiOperation("修改用户")
    @UserLoginToken(powerName = "user_up")
    public BaseResult<String> updateUser(AdminGroupUpRequest req){
        req.toRequestCheck();
        powerUtil.checkUserGroupAndUseGroup(req.getUserId(), req.getId());
        AdminUser user = new AdminUser();
        boolean flag = adminUserService.update(user);
        if(flag){
            BaseResult<String> result = BaseResult.newInstance();
            return result;
        }else{
            throw new BaseException(ResultValueEnum.OTHER_COMMON_MODIFY_ERROR);
        }
    }
}
