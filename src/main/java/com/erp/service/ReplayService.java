package com.erp.service;

import com.erp.pojo.Replay;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_replay】的数据库操作Service
* @createDate 2025-05-19 08:52:48
*/
public interface ReplayService extends IService<Replay> {

    public Map<String,Object> queryReplayListService(Integer id,Integer pageNum,Integer pageSize);
}
