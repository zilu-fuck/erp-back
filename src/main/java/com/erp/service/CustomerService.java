package com.erp.service;

import com.erp.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_customer】的数据库操作Service
* @createDate 2025-05-13 09:08:28
*/
public interface CustomerService extends IService<Customer> {
//    实现客户信息分页查询
    public Map<String,Object> queryCustListService(Integer pageNum,Integer pageSize);

//    查询所有客户的id和姓名
    public List<Customer> queryCustIdNameListService();
}
