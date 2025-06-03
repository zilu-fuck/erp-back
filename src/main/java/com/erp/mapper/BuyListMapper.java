package com.erp.mapper;

import com.erp.pojo.BuyList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_buy_list(采购单)】的数据库操作Mapper
* @createDate 2025-05-29 11:35:04
* @Entity com.erp.pojo.BuyList
*/
public interface BuyListMapper extends BaseMapper<BuyList> {
    public List<BuyList> queryBuyListMapper();
}




