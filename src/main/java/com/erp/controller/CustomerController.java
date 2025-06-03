package com.erp.controller;

import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCust")
    public Map<String,Object> saveCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        Map<String,Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "保存失败");
        try {
            customerService.save(customer);
            result.put("code", 200);
            result.put("msg", "保存成功");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping("/listCust")
    public Map<String,Object> queryCustList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return customerService.queryCustListService(pageNum, pageSize);
    }

    /*添加方法处理客户信息修改请求*/
    @PostMapping("/updateCust")
    public Map<String,Object> updateCustomer(@RequestBody Customer customer){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.....");
        try {
            customerService.updateById(customer);
            result.put("code",200);
            result.put("msg","客户信息修改成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping("/delCust")
    public Map<String,Object> deleteCustomer(@RequestParam Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "修改失败");
        try {
            customerService.removeById(id);
            result.put("code", 200);
            result.put("msg", "修改成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

//    处理加载所有客户列表请求
    @GetMapping("/listAllCust")
    public List<Customer> listAllCust(){
        return customerService.queryCustIdNameListService();
    }

}
