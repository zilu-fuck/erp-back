package com.erp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.vo.MenusVo;
import com.erp.pojo.Menus;
import com.erp.service.MenusService;
import com.erp.mapper.MenusMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author s1897
* @description 针对表【t_menus】的数据库操作Service实现
* @createDate 2025-05-13 14:31:02
*/
@Service
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus>
    implements MenusService{

    @Autowired
    private MenusMapper menusMapper;
    @Override
    //    加载左侧导航菜单，根据当前用户加载
    public List<MenusVo> queryMenusListService(){
        //查询所有菜单结点
        List<Menus> menus = menusMapper.selectList(null);
        //将菜单结点转化为list
        return doListMenus(menus,0);
    }

    @Override
    public void saveMenusService(Menus menus) {


        QueryWrapper<Menus> wrapper=new QueryWrapper<>();
        wrapper.select("max(component) maxv");
        //获得component的最大值
        Menus ms = menusMapper.selectOne(wrapper);

        //component组件属性的值，是数据库最大值加1
        menus.setComponent(ms.getMaxv()+1);
        menusMapper.insert(menus);

    }

    private List<MenusVo> doListMenus(List<Menus> menus,Integer id){
        List<MenusVo> result = new ArrayList<>();
        for (Menus menu : menus) {
            if(menu.getPid().equals(id)){
                MenusVo menusVo = new MenusVo();
                BeanUtils.copyProperties(menu,menusVo);
                menusVo.setSubMenus(doListMenus(menus,menu.getId()));
                result.add(menusVo);
            }
        }
        return result;
    }



}




