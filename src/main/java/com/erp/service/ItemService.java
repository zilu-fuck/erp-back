package com.erp.service;

import com.erp.pojo.Item;
import com.baomidou.mybatisplus.extension.service.IService;
import com.erp.vo.ItemCond;

import java.util.Map;

/**
* @author s1897
* @description 针对表【t_item】的数据库操作Service
* @createDate 2025-05-27 08:29:36
*/
public interface ItemService extends IService<Item> {
    /*实现商品信息分页查询*/
    public Map<String,Object> queryItemListService(ItemCond itemCond);

}
