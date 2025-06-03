package com.erp.service;

import com.erp.pojo.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_role_menu】的数据库操作Service
* @createDate 2025-05-19 14:32:06
*/
public interface RoleMenuService extends IService<RoleMenu> {
    public List<Integer> queryRoleMidsListService(Integer rid);

}
