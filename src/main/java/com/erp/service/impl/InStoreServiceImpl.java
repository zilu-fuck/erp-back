package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.mapper.BuyListMapper;
import com.erp.mapper.ItemMapper;
import com.erp.pojo.BuyList;
import com.erp.pojo.InStore;
import com.erp.pojo.Item;
import com.erp.service.InStoreService;
import com.erp.mapper.InStoreMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* @author s1897
* @description 针对表【t_in_store(入库单)】的数据库操作Service实现
* @createDate 2025-05-30 11:00:18
*/
@Service
public class InStoreServiceImpl extends ServiceImpl<InStoreMapper, InStore>
    implements InStoreService{
    @Autowired
    private BuyListMapper buyListMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private InStoreMapper inStoreMapper;

    @Override
    public void saveBuyOrderInStoreService(BuyList buyList) {
            //获得商品id
            Integer productId = buyList.getProductId();
            //通过商品id获得商品的库存
            Item goods = itemMapper.selectById(productId);

            Item item =new Item();
            item.setId(productId);
            item.setStore(goods.getStore()-buyList.getFactBuyNum());
            //跟新商品库存
            itemMapper.updateById(item);


            //获得采购单id
            Integer buyId=buyList.getBuyId();
            //更新采购单状态
            BuyList bl=new BuyList();
            bl.setBuyId(buyId);
            bl.setIsIn("0");
            buyListMapper.updateById(bl);

            //查询记录形成入库单
            InStore inStore=new InStore();
            inStore.setStoreId(buyList.getStoreId());
            inStore.setProductId(buyList.getProductId());
            inStore.setInNum(buyList.getFactBuyNum());
            inStore.setCreateBy(1009);
            inStore.setCreateTime(new Date());
            inStore.setIsIn("1");
            inStoreMapper.insert(inStore);
    }

    @Override
    public Map<String, Object> queryInStoreListService(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<InStore> inStore = inStoreMapper.queryInStoreListMapper();
        Map<String, Object> result = new HashMap<>();
        result.put("total", page.getTotal());
        result.put("inStore", inStore);
        return result;
    }


}




