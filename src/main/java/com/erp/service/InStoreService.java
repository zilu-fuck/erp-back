package com.erp.service;

import com.erp.pojo.BuyList;
import com.erp.pojo.InStore;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;

/**
* @author s1897
* @description 针对表【t_in_store(入库单)】的数据库操作Service
* @createDate 2025-05-30 11:00:18
*/
public interface InStoreService extends IService<InStore> {

    /*实现采购采购信息入库*/
    public void saveBuyOrderInStoreService(BuyList buyList);

    public Map<String, Object> queryInStoreListService(Integer pageNum, Integer pageSize);
}
