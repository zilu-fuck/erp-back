package com.erp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.dto.CountResult;
import com.erp.mapper.UserRoleMapper;
import com.erp.pojo.User;
import com.erp.pojo.UserRole;
import com.erp.service.UserRoleService;
import com.erp.service.UserService;
import com.erp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author s1897
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2025-05-19 14:32:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Map<String, Object> queryUserListService(int pageNum, int pageSize) {
        Map<String,Object> result = new HashMap<>();

        Page<User> page = new Page<>(pageNum,pageSize);
        List<User> userList =  userMapper.selectList(page,null);

        result.put("total",page.getTotal());
        result.put("userList",userList);
        return result;
    }

    @Transactional
    @Override
    public void saveUserRolerService(User user) {
        //保存用户信息,需要获得数据自增产生的用户id
        System.out.println("1----"+user.getId());
        //userMapper.insert(user);
        userMapper.saveUserMapper(user);
        user.setUpwd("123456");
        System.out.println("1----"+user.getId());
        Integer uid = user.getId();
        //获得当前角色id集合,从前台提交
        Integer[] rids=user.getRids();
        //保存用户和职位的关系
        for(Integer rid:rids){
            UserRole ur = new UserRole();
            ur.setRid(rid);
            ur.setUid(uid);
            userRoleMapper.insert(ur);
        }
    }

    @Override
    public void updateUserRolerService(User user) {

        //删除用户和角色的关系
        QueryWrapper<UserRole> del = new QueryWrapper<>();
        del.eq("uid",user.getId());
        userRoleMapper.delete(del);

        //更新用户信息
        userMapper.updateById(user);

        Integer[] rids = user.getRids();
        for(Integer rid:rids){
            UserRole ur = new UserRole();
            ur.setUid(user.getId());
            ur.setRid(rid);
            userRoleMapper.insert(ur);
        }
    }

    @Override
    public void deleteUserRolerService(Integer id) {
        userMapper.deleteById(id);

        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",id);
        userRoleMapper.delete(wrapper);

    }

    @Override
    public List<CountResult> countUserByAgeService() {
        return userMapper.countUserByAgeMapper();
    }

    @Override
    public List<CountResult> countUserByEduService() {
        return userMapper.countUserByEduMapper();
    }

}




