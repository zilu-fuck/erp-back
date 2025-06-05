package com.erp.controller;

import com.erp.pojo.Order;
import com.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

//    处理分页查询
    @PostMapping("/listOrder")
//    public Map<String, Object> listOrder(@RequestParam(defaultValue = "1")Integer pageNum,
//                                         @RequestParam(defaultValue = "10")Integer pageSize) {
//        return orderService.queryOrderListService(pageNum, pageSize);
//    }
    public Map<String,Object> listOrders(
            @RequestBody Order order){
        return orderService.queryOrderListService(order.getPageNum(),order.getPageSize(),order);
    }

    @GetMapping("/queryYear")
    public List<Map<String,Object>> queryYear(){
        return orderService.querySellYearService();
    }

    @GetMapping("/countSell")
    public Map<String,Object> countSell(String year){
        return orderService.querySellMonthService(year);
    }
}
