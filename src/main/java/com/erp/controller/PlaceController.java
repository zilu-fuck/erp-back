package com.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erp.pojo.Place;
import com.erp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/placeList")
    public List<Place> queryPlaceList(){
        QueryWrapper<Place> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("place_id","place_name");
        List<Place> list = placeService.list(queryWrapper);
        return list;
    }
}
