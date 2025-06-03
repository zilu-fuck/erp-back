package com.erp.service;

import com.erp.pojo.AfterSales;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author s1897
* @description 针对表【t_after_sales】的数据库操作Service
* @createDate 2025-05-13 09:08:28
*/
public interface AfterSalesService extends IService<AfterSales> {

    public Map<String, Object> queryAfterSalesService(AfterSales afterSales);

}
