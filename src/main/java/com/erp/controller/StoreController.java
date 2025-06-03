package com.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erp.pojo.Store;
import com.erp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
