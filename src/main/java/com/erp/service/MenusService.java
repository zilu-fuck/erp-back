package com.erp.service;

import com.erp.vo.MenusVo;
import com.erp.pojo.Menus;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_menus】的数据库操作Service
* @createDate 2025-05-13 14:31:02
*/
public interface MenusService extends IService<Menus> {
    //    加载左侧导航菜单，根据当前用户加载
    public List<MenusVo> queryMenusListService();

    /*添加菜单节点*/
    public void saveMenusService(Menus menus);

}
