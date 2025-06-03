package com.erp.service;

import com.erp.pojo.Categrory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.erp.vo.TreeVo;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_categrory】的数据库操作Service
* @createDate 2025-05-26 08:50:23
*/
public interface CategroryService extends IService<Categrory> {

    public List<TreeVo> queryCategroryListService();
}
