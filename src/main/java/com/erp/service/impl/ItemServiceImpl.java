package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.pojo.Item;
import com.erp.service.ItemService;
import com.erp.mapper.ItemMapper;
import com.erp.vo.ItemCond;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_item】的数据库操作Service实现
* @createDate 2025-05-27 08:29:36
*/
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item>
    implements ItemService{
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Map<String, Object> queryItemListService(ItemCond itemCond) {

//        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        Page<Object> page = PageHelper.startPage(itemCond.getPageNum(), itemCond.getPageSize());
        //查询数据库
//        List<Item> items = itemMapper.queryItemListMapper();
        List<Item> items = itemMapper.queryItemListMapper(itemCond);

        Map<String, Object> result=new HashMap<>();
        result.put("items",items);
        result.put("total",page.getTotal());
        return result;
    }

}




