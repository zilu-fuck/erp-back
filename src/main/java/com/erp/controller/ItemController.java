package com.erp.controller;

import com.erp.pojo.Item;
import com.erp.service.ItemService;
import com.erp.util.CodeUtils;
import com.erp.vo.ItemCond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class ItemController {

    @GetMapping("/getListCode")
    public String ItemCode(){
        return CodeUtils.toItemCode();
    }

    @Autowired
    private ItemService itemService;

    //处理商品信息保存
    @PostMapping("/saveItem")
    public Map<String,Object> saveItem(@RequestBody Item item){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","保存失败");
        try {

            itemService.save(item);
            result.put("code",200);
            result.put("msg","保存成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /*处理商品信息份额查询请求*/
//    @GetMapping("/itemList")
////    public Map<String,Object> itemList(@RequestParam(defaultValue = "1") Integer pageNum
////            ,@RequestParam(defaultValue = "3") Integer pageSize){
////        return itemService.queryItemListService(pageNum,pageSize);
////    }
    @PostMapping("/itemList")
    public Map<String,Object> itemList(@RequestBody ItemCond itemCond){
        return itemService.queryItemListService(itemCond);
    }

    @GetMapping("/downItem/{id}")
    public Map<String,Object> downItem(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","下架失败");
        try {
            Item item =new Item();
            item.setId(id);
            item.setStatue(1);
            itemService.updateById(item);
            result.put("code",200);
            result.put("msg","下架成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/delItem/{id}")
    public Map<String,Object> delItem(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","删除失败");
        try {
            Item item =new Item();
            item.setId(id);
            item.setStatue(2);
            itemService.updateById(item);
            result.put("code",200);
            result.put("msg","删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/upItem/{id}")
    public Map<String,Object> upItem(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","删除失败");
        try {
            Item item =new Item();
            item.setId(id);
            item.setStatue(0);
            itemService.updateById(item);
            result.put("code",200);
            result.put("msg","删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/updateItem")
    public Map<String,Object> updateItem(@RequestBody Item item){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","更新失败");
        try {
            itemService.updateById(item);
            result.put("code",200);
            result.put("msg","更新成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
