package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.mapper.ItemMapper;
import com.erp.pojo.Item;
import com.erp.pojo.OutStore;
import com.erp.service.OutStoreService;
import com.erp.mapper.OutStoreMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_out_store(出库单)】的数据库操作Service实现
* @createDate 2025-06-03 11:42:15
*/
@Service
public class OutStoreServiceImpl extends ServiceImpl<OutStoreMapper, OutStore>
    implements OutStoreService{

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private OutStoreMapper outStoreMapper;
    @Transactional
    @Override
    public void saveOutStoreService(OutStore outStore) {

        //根据商品查询对应商品的库存
        Item product = itemMapper.selectById(outStore.getProductId());

        Item item =new Item();
        item.setId(outStore.getProductId());
        item.setStore(product.getStore()-outStore.getOutNum());
        //实现商品信息的更新
        itemMapper.updateById(item);

        outStore.setIsOut("0");
        outStore.setCreateTime(new Date());
        outStore.setCreateBy(101010);
        outStore.setOutPrice(new BigDecimal(product.getSellPrice()));
        outStore.setStoreId(product.getStoreId());
        outStore.setProductId(product.getId());

        //实现出库单信息的保存
        outStoreMapper.insert(outStore);

    }

    @Override
    public Map<String, Object> queryOutStoreListMapper(Integer pageNum, Integer pageSize) {
        Map<String,Object> result = new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum,pageSize);

        List<OutStore> outStores = outStoreMapper.queryOutStoreMapper();
        result.put("total",page.getTotal());
        result.put("outStore",outStores);
        return result;
    }
}




