package com.erp.service;

import com.erp.dto.CountResult;
import com.erp.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.erp.pojo.UserRole;

import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_user】的数据库操作Service
* @createDate 2025-05-19 14:32:06
*/
public interface UserService extends IService<User> {
//实现用户信息分页查询
    public Map<String,Object> queryUserListService(int pageNum, int pageSize);

    public void saveUserRolerService(User user);

    public void updateUserRolerService(User user);

    public void deleteUserRolerService(Integer id);

//    实现员工按照年龄分段
    public List<CountResult> countUserByAgeService();

//    实现员工按学历统计
    public List<CountResult> countUserByEduService();
}
