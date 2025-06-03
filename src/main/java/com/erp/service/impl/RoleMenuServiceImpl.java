package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.mapper.RolerMapper;
import com.erp.pojo.RoleMenu;
import com.erp.service.RoleMenuService;
import com.erp.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_role_menu】的数据库操作Service实现
* @createDate 2025-05-19 14:32:06
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService{

    @Autowired
    private RolerMapper rolerMapper;

    @Override
    public List<Integer> queryRoleMidsListService(Integer rid) {
        return rolerMapper.queryRoleMidMapper(rid);
    }
}




