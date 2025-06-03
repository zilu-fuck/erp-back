package com.erp.mapper;

import com.erp.pojo.AfterSales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.erp.pojo.Order;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_after_sales】的数据库操作Mapper
* @createDate 2025-05-13 09:08:28
* @Entity com.erp.pojo.AfterSales
*/
public interface AfterSalesMapper extends BaseMapper<AfterSales> {

    /*实现售后数据多条件分页查询*/
    public List<AfterSales> queryAfterSaleMapper(AfterSales afterSales);

}




