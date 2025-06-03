package com.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erp.pojo.Unit;
import com.erp.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping("/unitList")
    public List<Unit> queryUnitList(){
        QueryWrapper<Unit> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("unit_id","unit_name");
        List<Unit> list = unitService.list(queryWrapper);
        return list;
    }
}
