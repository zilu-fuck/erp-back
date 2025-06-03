package com.erp.service;

import com.erp.pojo.BuyList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;

/**
* @author s1897
* @description 针对表【t_buy_list(采购单)】的数据库操作Service
* @createDate 2025-05-29 11:35:04
*/
public interface BuyListService extends IService<BuyList> {
    public Map<String,Object> queryAutoDataBuyService(Integer id);

//    采购单分页查询
    public Map<String,Object> queryBuyListService(Integer pageNum,Integer pageSize);

    public XSSFWorkbook exportExcelService();
}
