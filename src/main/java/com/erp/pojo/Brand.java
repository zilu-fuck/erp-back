package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 品牌
 * @TableName t_brand
 */
@TableName(value ="t_brand")
@Data
public class Brand {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer brandId;

    /**
     * 
     */
    private String brandName;

    /**
     * 
     */
    private String brandLeter;

    /**
     * 
     */
    private String brandDesc;
}