package com.xmm.biz.controller;

import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import com.xmm.biz.pojo.AdminGroup;
import com.xmm.biz.service.AdminGroupService;
import com.xmm.biz.target.UserLoginToken;
import com.xmm.biz.util.PowerUtil;
import com.xmm.biz.vo.request.AdminGroupAddRequest;
import com.xmm.biz.vo.request.AdminGroupUpRequest;
import com.xmm.biz.vo.request.AdminIdRequest;
import com.xmm.biz.vo.request.BaseRequest;
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
@RequestMapping(value = "/group")
@Api(tags = "组织相关")
public class AdminGroupController {

    @Autowired
    AdminGroupService adminGroupService;

    @Autowired
    PowerUtil powerUtil;

    @RequestMapping(name = "组织列表", value = "/find")
    @ResponseBody
    @ApiOperation("组织列表")
    @UserLoginToken(powerName = "group_sel")
    public BaseResult<List<GroupResult>> findGroup(BaseRequest req){
        BaseResult<List<GroupResult>> result = BaseResult.newInstance();
        List<GroupResult> list = adminGroupService.findByUser(req.getUserId());
        result.setData(list);
        return result;
    }

    @RequestMapping(name = "新增组织", value = "/add")
    @ResponseBody
    @ApiOperation("新增组织")
    @UserLoginToken(powerName = "group_add")
    public BaseResult<GroupResult> addGroup(AdminGroupAddRequest req){
        req.toRequestCheck();
        powerUtil.checkUserGroupAndUseGroup(req.getUserId(), req.getParentId());
        AdminGroup group = new AdminGroup();
        group.setGroupname(req.getGroupName());
        group.setParentid(req.getParentId());
        group.setUpdator(req.getUsername());
        int row = adminGroupService.add(group);
        if(row == 1){
            GroupResult groupResult = new GroupResult();
            groupResult.setId(group.getId());
            BaseResult<GroupResult> result = BaseResult.newInstance();
            result.setData(groupResult);
            return result;
        }else{
            throw new BaseException(ResultValueEnum.OTHER_COMMON_MODIFY_ERROR);
        }
    }

    @RequestMapping(name = "删除组织", value = "/delete")
    @ResponseBody
    @ApiOperation("删除组织")
    @UserLoginToken(powerName = "group_del")
    public BaseResult<String> deleteGroup(AdminIdRequest req){
        req.toRequestCheck();
        powerUtil.checkUserGroupAndUseGroup(req.getUserId(), req.getId());
        boolean flag = adminGroupService.delete(req.getId());
        if(flag){
            BaseResult<String> result = BaseResult.newInstance();
            return result;
        }else{
            throw new BaseException(ResultValueEnum.OTHER_COMMON_MODIFY_ERROR);
        }
    }

    @RequestMapping(name = "修改组织", value = "/update")
    @ResponseBody
    @ApiOperation("修改组织")
    @UserLoginToken(powerName = "group_up")
    public BaseResult<String> updateGroup(AdminGroupUpRequest req){
        req.toRequestCheck();
        powerUtil.checkUserGroupAndUseGroup(req.getUserId(), req.getId());
        AdminGroup group = new AdminGroup();
        group.setId(req.getId());
        group.setGroupname(req.getGroupName());
        group.setParentid(req.getParentId());
        group.setSort(Integer.valueOf(req.getSort()).byteValue());
        group.setState(Integer.valueOf(req.getState()).byteValue());
        group.setUpdator(req.getUsername());
        boolean flag = adminGroupService.update(group);
        if(flag){
            BaseResult<String> result = BaseResult.newInstance();
            return result;
        }else{
            throw new BaseException(ResultValueEnum.OTHER_COMMON_MODIFY_ERROR);
        }
    }
}
