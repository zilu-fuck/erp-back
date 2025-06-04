package com.erp.mapper;

import com.erp.dto.CountResult;
import com.erp.pojo.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_customer】的数据库操作Mapper
* @createDate 2025-05-13 09:08:28
* @Entity com.erp.pojo.Customer
*/
public interface CustomerMapper extends BaseMapper<Customer> {

//    实现客户地区分布统计
    public List<CountResult> countCustomerAreaMapper();
}




