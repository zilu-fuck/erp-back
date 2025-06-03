package com.erp.service;

import com.erp.pojo.SellJh;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author s1897
* @description 针对表【t_sell_jh】的数据库操作Service
* @createDate 2025-05-13 09:08:28
*/
public interface SellJhService extends IService<SellJh> {

//    分页查询方法
    public Map<String,Object> querySellJhListService(Integer pageNum,Integer pageSize);

}
