package com.xmm.biz.service.impl;

import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import com.xmm.biz.dao.AdminCatalogDao;
import com.xmm.biz.dao.AdminMenuDao;
import com.xmm.biz.dao.AdminPowerDao;
import com.xmm.biz.dao.AdminUserDao;
import com.xmm.biz.pojo.*;
import com.xmm.biz.service.AdminService;
import com.xmm.biz.util.TokenUtil;
import com.xmm.biz.vo.model.CatalogVo;
import com.xmm.biz.vo.model.MenuVo;
import com.xmm.biz.vo.model.PowerVo;
import com.xmm.biz.vo.result.AdminDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminUserDao adminUserDao;

    @Autowired
    AdminPowerDao adminPowerDao;

    @Autowired
    AdminMenuDao adminMenuDao;

    @Autowired
    AdminCatalogDao adminCatalogDao;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public AdminDataResult adminLogin(String username, String password) {
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPwdEqualTo(password);
        List<AdminUser> list = adminUserDao.selectByExample(example);
        if(list.size() > 0){
            AdminUser adminUser = list.get(0);
            if(adminUser.getState() == 1){
                AdminDataResult dataResult = new AdminDataResult();
                dataResult.setUsername(adminUser.getUsername());
                dataResult.setToken(tokenUtil.createTokenByLogin(adminUser.getId()));
                dataResult.setCatalogList(getCatalogsByUser(adminUser.getId()));
                return dataResult;
            }else{
                throw new BaseException(ResultValueEnum.OTHER_USER_LOCK);
            }
        }else {
            throw new BaseException(ResultValueEnum.OTHER_USER_NOT_EXIST);
        }
    }

    @Override
    public List<CatalogVo> getCatalogsByUser(long userId) {
        List<AdminPower> powerList = adminPowerDao.findByUser(userId);
        if(powerList.size() > 0){
            Set<Long> menuIds = new HashSet<>();
            for(AdminPower adminPower : powerList){
                menuIds.add(adminPower.getMenuid());
            }
            AdminMenuExample menuExample = new AdminMenuExample();
            AdminMenuExample.Criteria menuExampleCriteria = menuExample.createCriteria();
            menuExample.setOrderByClause("sort");
            menuExampleCriteria.andIdIn(new ArrayList<>(menuIds));
            menuExampleCriteria.andStateEqualTo(Integer.valueOf(1).byteValue());
            List<AdminMenu> menuList = adminMenuDao.selectByExample(menuExample);
            Set<Long> catalogIds = new HashSet<>();
            for(AdminMenu adminMenu : menuList){
                catalogIds.add(adminMenu.getCatalogid());
            }
            AdminCatalogExample catalogExample = new AdminCatalogExample();
            AdminCatalogExample.Criteria catalogExampleCriteria= catalogExample.createCriteria();
            catalogExample.setOrderByClause("sort");
            catalogExampleCriteria.andIdIn(new ArrayList<>(catalogIds));
            catalogExampleCriteria.andStateEqualTo(Integer.valueOf(1).byteValue());
            List<AdminCatalog> catalogList = adminCatalogDao.selectByExample(catalogExample);
            List<CatalogVo> catalogVoList = new ArrayList<>();
            for(AdminCatalog adminCatalog : catalogList){
                CatalogVo catalogVo = new CatalogVo();
                catalogVo.setCatalogName(adminCatalog.getCatalogname());
                catalogVo.setIcon(adminCatalog.getIcon());
                List<MenuVo> menuVoList = new ArrayList<>();
                for(AdminMenu adminMenu: menuList){
                    if(adminMenu.getCatalogid().equals(adminCatalog.getId())){
                        MenuVo menuVo = new MenuVo();
                        menuVo.setMenuName(adminMenu.getMenuname());
                        menuVo.setUrl(adminMenu.getUrl());
                        List<PowerVo> powerVos = new ArrayList<>();
                        for(AdminPower adminPower : powerList){
                            if(adminPower.getMenuid().equals(adminMenu.getId())){
                                PowerVo powerVo = new PowerVo();
                                powerVo.setPowerName(adminPower.getPowername());
                                powerVo.setPowerEnum(adminPower.getPowerenum());
                                powerVos.add(powerVo);
                            }
                        }
                        menuVo.setPowers(powerVos);
                        menuVoList.add(menuVo);
                    }
                }
                catalogVo.setMenus(menuVoList);
                catalogVoList.add(catalogVo);
            }
            return catalogVoList;
        }else{
            throw new BaseException(ResultValueEnum.OTHER_USER_NOT_POWER);
        }
    }
}
