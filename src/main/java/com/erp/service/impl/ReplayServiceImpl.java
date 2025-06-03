package com.erp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.pojo.Replay;
import com.erp.service.ReplayService;
import com.erp.mapper.ReplayMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_replay】的数据库操作Service实现
* @createDate 2025-05-19 08:52:48
*/
@Service
public class ReplayServiceImpl extends ServiceImpl<ReplayMapper, Replay>
    implements ReplayService{

    @Autowired
    private ReplayMapper replayMapper;


    @Override
    public Map<String, Object> queryReplayListService(Integer id,Integer pageNum,Integer pageSize) {
        Page<Replay> page = new Page<>(pageNum,pageSize);

        QueryWrapper<Replay> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("question_id",id);

        List<Replay> replayList =  replayMapper.selectList(page,null);
        Map<String,Object> result = new HashMap<>();
        result.put("total",page.getTotal());
        result.put("replayList",replayList);
        return result;
    }
}




