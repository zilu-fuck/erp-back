package com.erp.mapper;

import com.erp.pojo.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.erp.vo.ItemCond;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_item】的数据库操作Mapper
* @createDate 2025-05-27 08:29:36
* @Entity com.erp.pojo.Item
*/
public interface ItemMapper extends BaseMapper<Item> {
    /*实现商品信息分页查询*/
    public List<Item> queryItemListMapper(ItemCond itemCond);
}




