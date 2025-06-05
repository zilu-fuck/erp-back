package com.erp.mapper;

import com.erp.dto.CountResult;
import com.erp.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2025-05-19 14:32:06
* @Entity com.erp.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
//保存用户信息
    public void saveUserMapper(User user);

//    实现用户按照年龄段分布统计
    public List<CountResult> countUserByAgeMapper();
//    实现用户按照学历分布
    public List<CountResult> countUserByEduMapper();
}




