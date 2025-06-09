package com.erp.mapper;

import com.erp.dto.HisData;
import com.erp.dto.SellResult;
import com.erp.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2025-05-13 09:08:28
* @Entity com.erp.pojo.Order
*/
public interface OrderMapper extends BaseMapper<Order> {

//    查询统计每个客户的历史消费总额
    public List<HisData> queryCountHisDataMapper();


//    实现订单数据多条件分页动态查询
    public List<Order> queryOrderListMapper(Order order);

//    统计查询销售数据的年份
    public List<Integer> querySellYearMapper();

//    统计查询某个年份十二个月的销售额
    public List<SellResult> querySellMonthMapper(String year);

//    实现年12个月销售商品数量的统计
    public List<SellResult> countSellNumMapper(String year);
}




