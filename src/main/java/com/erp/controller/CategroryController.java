package com.erp.controller;

import com.erp.pojo.Categrory;
import com.erp.service.CategroryService;
import com.erp.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CategroryController {

    @Autowired
    private CategroryService categroryService;

    @GetMapping("/categroryList")
    public List<TreeVo> CategroryList(){
        return categroryService.queryCategroryListService();
    }

    //处理商品类别新增
    @PostMapping("/saveCategrory")
    public Map<String,Object> saveCategrory(@RequestBody Categrory categrory){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            categroryService.save(categrory);
            result.put("code",200);
            result.put("msg","添加商品类目成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping("/loadCategrory/{id}")
    public Categrory loadCategrory(@PathVariable Integer id){
        return categroryService.getById(id);
    }

    @PostMapping("/updateCategrory")
    public Map<String,Object> updateCategrory(@RequestBody Categrory categrory){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            categroryService.updateById(categrory);
            result.put("code",200);
            result.put("msg","更新商品类目成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping("/deleteCategrory/{id}")
    public Map<String,Object> deleteCategrory(@PathVariable Integer id){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            categroryService.removeById(id);
            result.put("code",200);
            result.put("msg","删除商品类目成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
