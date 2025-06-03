package com.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erp.pojo.Brand;
import com.erp.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brandList")
    public List<Brand> queryAllBrands(){
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("brand_id","brand_name");
        List<Brand> list = brandService.list(queryWrapper);
        return list;
    }
}
