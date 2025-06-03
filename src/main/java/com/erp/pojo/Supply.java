package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 供货商
 * @TableName t_supply
 */
@TableName(value ="t_supply")
@Data
public class Supply {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer supplyId;

    /**
     * 
     */
    private String supplyNum;

    /**
     * 
     */
    private String supplyName;

    /**
     * 
     */
    private String supplyIntroduce;

    /**
     * 
     */
    private String concat;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String address;

    /**
     * 0:可用  1:不可用
     */
    private String isDelete;
}