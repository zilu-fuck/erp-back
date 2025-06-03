package com.erp.service;

import com.erp.pojo.OutStore;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author s1897
* @description 针对表【t_out_store(出库单)】的数据库操作Service
* @createDate 2025-06-03 11:42:15
*/
public interface OutStoreService extends IService<OutStore> {
    /*实现商品出库*/
    public void saveOutStoreService(OutStore outStore);
}
