package com.erp.mapper;

import com.erp.pojo.SellJh;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_sell_jh】的数据库操作Mapper
* @createDate 2025-05-13 09:08:28
* @Entity com.erp.pojo.SellJh
*/
public interface SellJhMapper extends BaseMapper<SellJh> {
    //查询客户销售过程记录列表
    public List querySellJhListMapper();
}




