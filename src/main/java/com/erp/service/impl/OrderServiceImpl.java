package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.pojo.Order;
import com.erp.service.OrderService;
import com.erp.mapper.OrderMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2025-05-13 09:08:28
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Map<String, Object> queryOrderListService(Integer pageNum, Integer pageSize,Order order) {

        Map<String, Object> result = new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.queryOrderListMapper(order);

        result.put("orderList", orderList);
        result.put("total", page.getTotal());
        return result;
    }
}




