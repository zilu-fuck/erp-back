package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.dto.CountResult;
import com.erp.pojo.AfterSales;
import com.erp.service.AfterSalesService;
import com.erp.mapper.AfterSalesMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_after_sales】的数据库操作Service实现
* @createDate 2025-05-13 09:08:28
*/
@Service
public class AfterSalesServiceImpl extends ServiceImpl<AfterSalesMapper, AfterSales>
        implements AfterSalesService{

    @Autowired
    private AfterSalesMapper afterSalesMapper;

    @Override
    public Map<String, Object> queryAfterSalesService(AfterSales afterSales) {
        //指定分页查询参数
        Page<Object> page = PageHelper.startPage(afterSales.getPageNum(), afterSales.getPageSize());
        //查询数据库
        List<AfterSales> afterSalesList = afterSalesMapper.queryAfterSaleMapper(afterSales);

        Map<String, Object> result=new HashMap<>();
        result.put("afterSalesList",afterSalesList);
        result.put("total",page.getTotal());
        return result;
    }

    @Override
    public List<CountResult> countQuestionService() {
        return afterSalesMapper.countQuestionMapper();
    }

    @Override
    public List<CountResult> countQuestionStateService() {
        return afterSalesMapper.countQuestionStateMapper();
    }
}




