package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.dto.SellResult;
import com.erp.pojo.Order;
import com.erp.service.OrderService;
import com.erp.mapper.OrderMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Map<String,Object>> querySellYearService() {
        List<Integer> integerList = orderMapper.querySellYearMapper();
        List<Map<String,Object>> list = new ArrayList<>();
        for(Integer year : integerList){
            Map<String,Object> result = new HashMap<>();
//            System.out.println(year);
            result.put("year",year);
            result.put("lable",year+"年");
            list.add(result);
        }
        return list;
    }

    @Override
    public Map<String, Object> querySellMonthService(String year) {
        List<SellResult> sellResults = orderMapper.querySellMonthMapper(year);
        Map<String,Object> result = new HashMap<>();

//        创建封装月份集合
        List<String> months = new ArrayList();
//        创建封装总数的集合
        List<Double> sums = new ArrayList<>();
        //设置默认初值
        for(int m=1;m<=12;m++){
            months.add(m+"月");
            sums.add(0.0);
        }

        for(SellResult sellResult : sellResults){
            if(sellResult != null) {
                Integer month = sellResult.getMonth();
                sums.set(month - 1, sellResult.getSum());//如果某个月份存在数据，则覆盖默认数据0.0
            }
        }

        result.put("xdata",months);
        result.put("ydata",sums);

        return result;
    }
}




