package com.erp.controller;

import com.erp.dto.CountResult;
import com.erp.pojo.AfterSales;
import com.erp.service.AfterSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AfterSalesController {

    @Autowired
    private AfterSalesService afterSalesService;

    /*处理投诉信息分页查询请求*/
    @PostMapping("/listAfterSale")
    public Map<String,Object> listAfterSales(@RequestBody AfterSales afterSales){
        return afterSalesService.queryAfterSalesService(afterSales);
    }

    @GetMapping("/countQuestion")
    public List<CountResult> countQuestion(){
        return afterSalesService.countQuestionService();
    }

}
