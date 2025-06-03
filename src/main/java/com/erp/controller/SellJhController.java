package com.erp.controller;

import com.erp.pojo.SellJh;
import com.erp.service.SellJhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class SellJhController {

    @Autowired
    private SellJhService sellJhService;

    @PostMapping("/saveSell")
    public Map<String,Object> saveSellJh(@RequestBody SellJh sellJh) {
        System.out.println(sellJh);
        Map<String,Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "保存失败");
        try {
            sellJhService.save(sellJh);
            result.put("code", 200);
            result.put("msg", "保存成功");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping("/sellList")
    public Map<String,Object> querySellJhList(
            @RequestParam(defaultValue = "1")Integer pageNum
            , @RequestParam(defaultValue = "10") Integer pageSize) {
        return sellJhService.querySellJhListService(pageNum,pageSize);
    }

    /*处理客户销售渠道数据更新请求*/
    @PostMapping("/updateSellJh")
    public Map<String,Object> updateSellJh(@RequestBody SellJh sellJh){

        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            sellJhService.updateById(sellJh);
            result.put("code",200);
            result.put("msg","更新客户销售过程数据成功.........");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    //    处理客户销售渠道数据删除请求
    @GetMapping("/deleteSell")
    public Map<String,Object> deleteSellJh(Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "删除失败");
        try {
            sellJhService.removeById(id);
            result.put("code", 200);
            result.put("msg", "删除成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


}
