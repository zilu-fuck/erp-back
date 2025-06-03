package com.erp.mapper;

import com.erp.pojo.Roler;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author s1897
* @description 针对表【t_roler】的数据库操作Mapper
* @createDate 2025-05-19 14:32:07
* @Entity com.erp.pojo.Roler
*/
public interface RolerMapper extends BaseMapper<Roler> {
//    查询某个角色的所有菜单叶子节点的id集合
public List<Integer> queryRoleMidMapper(Integer id);
}




