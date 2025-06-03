package com.erp.service;

import com.erp.pojo.Roler;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_roler】的数据库操作Service
* @createDate 2025-05-19 14:32:07
*/
public interface RolerService extends IService<Roler> {
//    实现角色信息分页查询
    public Map<String,Object> queryRolerPageListService(Integer pageNum, Integer pageSize);

}
