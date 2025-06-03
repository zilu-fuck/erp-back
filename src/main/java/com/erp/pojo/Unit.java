package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 规格单位表
 * @TableName t_unit
 */
@TableName(value ="t_unit")
@Data
public class Unit {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer unitId;

    /**
     * 
     */
    private String unitName;

    /**
     * 
     */
    private String unitDesc;
}