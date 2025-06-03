package com.erp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erp.pojo.User;
import com.erp.service.UserRoleService;
import com.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public Map<String, Object> userList(
            @RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "3") Integer pageSize){
        return userService.queryUserListService(pageNum, pageSize);
    }

//    @PostMapping("saveUser")
//    private Map<String, Object> saveUser(@RequestBody User user){
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("code",400);
//        result.put("msg","保存失败");
//        try{
//            userService.save(user);
//            result.put("code",200);
//            result.put("msg","保存成功");
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return result;
//    }

    @PostMapping("/saveUser")
    public Map<String, Object> saveUser(@RequestBody User user){
        Map<String, Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","保存失败");
        try{
            userService.saveUserRolerService(user);
            result.put("code",200);
            result.put("msg","保存成功");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }


    @Autowired
    private UserRoleService userRoleService;
    /*根据用户id查询某个用户的所有角色id*/
    @GetMapping("/queryUserRids/{id}")
    public List<Integer> queryUserRids(@PathVariable Integer id){

        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("uid",id); //where uid=?
        wrapper.select("rid");
        List<Integer> list = userRoleService.listObjs(wrapper);
        return list;

    }

    @PostMapping("/updateUser")
    public Map<String, Object> updateUser(@RequestBody User user){
        Map<String, Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","更新失败");
        try{
            userService.updateUserRolerService(user);
            result.put("code",200);
            result.put("msg","更新成功");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping("/deleteUser/{id}")
    public Map<String, Object> deleteUser(@PathVariable Integer id){
        Map<String, Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","删除失败");
        try{
            userService.deleteUserRolerService(id);
            result.put("code",200);
            result.put("msg","删除成功");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

}
