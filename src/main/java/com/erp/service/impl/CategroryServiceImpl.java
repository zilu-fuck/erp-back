package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.pojo.Categrory;
import com.erp.service.CategroryService;
import com.erp.mapper.CategroryMapper;
import com.erp.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author s1897
* @description 针对表【t_categrory】的数据库操作Service实现
* @createDate 2025-05-26 08:50:23
*/
@Service
public class CategroryServiceImpl extends ServiceImpl<CategroryMapper, Categrory>
    implements CategroryService{

    @Autowired
    private CategroryMapper categroryMapper;

    @Override
    public List<TreeVo> queryCategroryListService() {
        List<Categrory> categrories = categroryMapper.selectList(null);

        return toListTreeVo(categrories,0);
    }

    private List<TreeVo> toListTreeVo(List<Categrory> categrories,Integer id) {
        List<TreeVo> result = new ArrayList<>();
        for (Categrory categrory : categrories) {
            if(categrory.getPid() == id){
                TreeVo treeVo = new TreeVo();
                treeVo.setId(categrory.getId());
                treeVo.setLabel(categrory.getCateName());
                treeVo.setChildren(toListTreeVo(categrories,categrory.getId()));
                result.add(treeVo);
            }
        }
        return result;
    }
}




