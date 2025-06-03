package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.pojo.Roler;
import com.erp.service.RolerService;
import com.erp.mapper.RolerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_roler】的数据库操作Service实现
* @createDate 2025-05-19 14:32:06
*/
@Service
public class RolerServiceImpl extends ServiceImpl<RolerMapper, Roler>
    implements RolerService{

    @Autowired
    private RolerMapper rolerMapper;

    @Override
    public Map<String, Object> queryRolerPageListService(Integer pageNum, Integer pageSize) {

//        指定分页查询参数
        Page<Roler> page = new Page<>(pageNum, pageSize);
        List<Roler> rolerList = rolerMapper.selectList(page, null);
        Map<String,Object> result = new HashMap<>();
        result.put("total", page.getTotal());
        result.put("rolerList", rolerList);
        return result;
    }

}




