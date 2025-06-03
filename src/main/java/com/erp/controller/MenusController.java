package com.erp.controller;

import com.erp.pojo.Menus;
import com.erp.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.erp.vo.MenusVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menus")
public class MenusController {

    @Autowired
    private MenusService menusService;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/listMenus")
    public List<MenusVo> listMenus() {
        return menusService.queryMenusListService();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/compIndex")
    public Integer compIndex(Integer id) {
        Menus menus = menusService.getById(id);
        return menus.getComponent();
    }

    /*处理菜单节点信息的添加请求*/
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/saveMenus")
    public Map<String,Object> saveMenus(@RequestBody Menus menus){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            menusService.saveMenusService(menus);
            result.put("code",200);
            result.put("msg","添加菜单节点成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/delMenus/{id}")
    public Map<String,Object> delMenus(@PathVariable Integer id){

        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            menusService.removeById(id);
            result.put("code",200);
            result.put("msg","删除菜单节点成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/updateMenus")
    public Map<String,Object> updateMenus(@RequestBody Menus menus){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            menusService.updateById(menus);
            result.put("code",200);
            result.put("msg","更新菜单节点成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
