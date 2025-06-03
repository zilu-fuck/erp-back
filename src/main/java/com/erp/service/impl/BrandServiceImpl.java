package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.pojo.Brand;
import com.erp.service.BrandService;
import com.erp.mapper.BrandMapper;
import org.springframework.stereotype.Service;

/**
* @author s1897
* @description 针对表【t_brand(品牌)】的数据库操作Service实现
* @createDate 2025-05-27 08:29:36
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
    implements BrandService{

}




