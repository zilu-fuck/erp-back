package com.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erp.pojo.Store;
import com.erp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/storeList")
    public List<Store> queryAllStores(){
        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("brand_id","brand_name");
        List<Store> list = storeService.list();
        return list;
    }
//分页查询
    @GetMapping("/storePageList")
    public Map<String,Object> queryStorePageList(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize){

        Page<Store> page = new Page<>(pageNum,pageSize);

        List<Store> storeList = storeService.list(page);
        Map<String,Object> result = new HashMap<>();
        result.put("total",page.getTotal());
        result.put("storeList",storeList);
        return result;

    }

    @PostMapping("/addStore")
    public Map<String,Object> addStore(@RequestBody Store store){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","添加失败");
        try {
            storeService.save(store);
            result.put("code",200);
            result.put("msg","添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/updateStore")
    public Map<String,Object> updateStore(@RequestBody Store store){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","更新失败");
        try {
            storeService.updateById(store);
            result.put("code",200);
            result.put("msg","更新成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/deleteStore/{id}")
    public Map<String,Object> deleteStore(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "删除失败");
        try{
        storeService.removeById(id);
        result.put("code", 200);
        result.put("msg", "删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
