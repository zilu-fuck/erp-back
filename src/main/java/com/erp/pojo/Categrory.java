package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName t_categrory
 */
@TableName(value ="t_categrory")
@Data
public class Categrory {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String isbn;

    /**
     * 
     */
    private String cateName;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private Integer pid;
}