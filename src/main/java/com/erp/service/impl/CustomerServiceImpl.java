package com.erp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.dto.CountResult;
import com.erp.dto.HisData;
import com.erp.mapper.OrderMapper;
import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import com.erp.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_customer】的数据库操作Service实现
* @createDate 2025-05-13 09:08:28
*/
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    @Override
    public Map<String, Object> queryCustListService(Integer pageNum, Integer pageSize) {

        //        将客户历史消费信息更新到客户信息表
        List<HisData> hisDatas = orderMapper.queryCountHisDataMapper();

        for(HisData hisData:hisDatas) {
            Customer cust = new Customer();
            cust.setId(hisData.getCustId());
            cust.setHisTotal(hisData.getHisTotal());
            customerMapper.updateById(cust);
        }

        Map<String,Object> result = new HashMap<>();
//        创建封装分页查询参数的page对象
        Page<Customer> page =new Page(pageNum,pageSize);
//        System.out.println(page.getTotal());
        Page<Customer> customerPage = customerMapper.selectPage(page,null);
//        System.out.println(page.getTotal());

        result.put("custList", customerPage.getRecords());
        result.put("total", customerPage.getTotal());
        return result;
    }


    @Override
    public List<Customer> queryCustIdNameListService() {

        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.select("id","cust_name");
        List<Customer> customerList = customerMapper.selectList(wrapper);
        return customerList;
    }

    @Override
    public List<CountResult> countCustomerService() {
        return customerMapper.countCustomerAreaMapper();
    }


}




