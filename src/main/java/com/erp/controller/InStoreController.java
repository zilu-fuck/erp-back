package com.erp.controller;

import com.erp.pojo.BuyList;
import com.erp.pojo.InStore;
import com.erp.service.InStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class InStoreController {
    @Autowired
    private InStoreService inStoreService;

    /*处理采购单入库请求*/
    @PostMapping("/buyInStore")
    public Map<String,Object> buyInStore(@RequestBody BuyList buyList){
        Map<String,Object> result=new HashMap<>();
        result.put("code","操作失败......");
        result.put("code",400);
        try{
            inStoreService.saveBuyOrderInStoreService(buyList);
            result.put("code",200);
            result.put("msg","采购单入库成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping("/queryInStoreList")
    public Map<String,Object> queryInStoreList(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "3") Integer pageSize){
        return inStoreService.queryInStoreListService(pageNum,pageSize);
    }

    @PostMapping("/updateInStore/{id}")
    public Map<String,Object> updateInStore(@PathVariable Integer id){
        Map<String,Object> result=new HashMap<>();
        result.put("msg","操作失败......");
        result.put("code",400);
        try{
            InStore inStore = new InStore();
            inStore.setInsId(id);
            inStore.setIsIn("0");
            inStoreService.updateById(inStore);

            result.put("code",200);
            result.put("msg","采购单入库成功.....");
            }catch (Exception ex){
            ex.printStackTrace();
            }
        return result;
    }
}
