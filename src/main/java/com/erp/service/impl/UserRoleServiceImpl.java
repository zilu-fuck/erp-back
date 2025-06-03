package com.erp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.mapper.UserMapper;
import com.erp.pojo.User;
import com.erp.pojo.UserRole;
import com.erp.service.UserRoleService;
import com.erp.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author s1897
* @description 针对表【t_user_role】的数据库操作Service实现
* @createDate 2025-05-19 14:32:06
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




