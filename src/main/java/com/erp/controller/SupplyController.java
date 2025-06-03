package com.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erp.pojo.Supply;
import com.erp.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SupplyController {

    @Autowired
    private SupplyService supplyService;

    @GetMapping("/supplyList")
    public List<Supply> querySupplyList(){

        QueryWrapper<Supply> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("supply_id","supply_name");
        List<Supply> list = supplyService.list();
        return list;
    }
}
