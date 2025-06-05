package com.erp.service;

import com.erp.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_order】的数据库操作Service
* @createDate 2025-05-13 09:08:28
*/
public interface OrderService extends IService<Order> {

//    添加处理订单多条件分页动态查询
    public Map<String,Object> queryOrderListService(Integer pageNum,Integer pageSize,Order order);

//    统计销售数据年份
    public List<Map<String,Object>> querySellYearService();

    public Map<String,Object> querySellMonthService(String year);
}
