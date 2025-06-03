package com.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erp.pojo.RoleMenu;
import com.erp.pojo.Roler;
import com.erp.service.RoleMenuService;
import com.erp.service.RolerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class RolerController {
    @Autowired
    private RolerService rolerService;

    @GetMapping("/rolerList")
    public Map<String, Object> rolerList(@RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "3") Integer pageSize) {
        return rolerService.queryRolerPageListService(pageNum, pageSize);
    }

    @PostMapping("/updateRoler")
    public Map<String, Object> updateRoler(@RequestBody Roler roler) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "更新失败");
        try {
            rolerService.updateById(roler);
            result.put("code", 200);
            result.put("msg", "更新成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //    处理角色信息添加的请求
    @PostMapping("/saveRoler")
    public Map<String, Object> saveRoler(@RequestBody Roler roler) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "添加失败");
        try {
            rolerService.save(roler);
            result.put("code", 200);
            result.put("msg", "添加成功");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping("/deleteRoler/{id}")
    public Map<String, Object> deleteRoler(@RequestParam Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "删除失败");
        try {
            rolerService.removeById(id);
            //删除角色对应的菜单信息
            QueryWrapper<RoleMenu> cond=new QueryWrapper<>();
            cond.eq("rid",id);
            roleMenuService.remove(cond);
            result.put("code", 200);
            result.put("msg", "删除成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    @Autowired
    private RoleMenuService roleMenuService;

    /*处理角色授权请求*/
    @PostMapping("/grantRoleMenus")
    public Map<String,Object> grantRoleMenus(@RequestBody Integer[] ids){
        if(ids==null||ids.length==0) {
            Map<String,Object> result=new HashMap<>();
            result.put("code",400);
            result.put("msg","操作失败.......");
            return result;
        }
        System.out.println("ids="+ Arrays.toString(ids));
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            //数组中获得第一个元素，角色id
            Integer  rid=ids[0];

            List<RoleMenu> list=new ArrayList<>();

            //for循环便利
            for(int x=1;x<ids.length;x++){
                //完成角色授权，给角色和菜单的中间关系添加数据，建立关系
                RoleMenu rm=new RoleMenu();
                rm.setRid(rid);
                rm.setMid(ids[x]);
                //将rm对象添加到list集合
                list.add(rm);

            }
            //创建对象，封装删除的where条件
            QueryWrapper<RoleMenu> cond=new QueryWrapper<>();
            cond.eq("rid",rid);
            //断开该角色和菜单的关系，执行删除
            roleMenuService.remove(cond);

            //建立角色和菜单的关系
            roleMenuService.saveBatch(list); //批量添加

            result.put("code",200);
            result.put("msg","角色授权成功......");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }


    //根据角色id查询菜单列
    @GetMapping("loadRoleMid/{rid}")
    public List<Integer> loadRoleMenu(@PathVariable Integer rid){

//        QueryWrapper <RoleMenu> wrapper = new QueryWrapper<>();
//        wrapper.eq("rid",rid);
//        wrapper.select("mid");
//        List<Integer> result = roleMenuService.listObjs(wrapper);
        return roleMenuService.queryRoleMidsListService(rid);
    }

    //加载所有角色信息
    @GetMapping("/roleAllList")
    public List<Roler> loadAllRole(){


        QueryWrapper<Roler> wrapper = new QueryWrapper<>();
        wrapper.select("id","rname");
        List<Roler> list = rolerService.list(wrapper);
        return list;
    }

}