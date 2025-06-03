package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 采购单
 * @TableName t_buy_list
 */
@TableName(value ="t_buy_list")
@Data
public class BuyList {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer buyId;

    /**
     * 
     */
    private Integer productId;

    /**
     * 
     */
    private Integer storeId;

    /**
     * 
     */
    private Integer buyNum;

    /**
     * 
     */
    private Integer factBuyNum;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date buyTime;

    /**
     * 
     */
    private Integer supplyId;

    /**
     * 
     */
    private Integer placeId;

    /**
     * 
     */
    private String buyUser;

    /**
     * 
     */
    private String phone;

    /**
     * 0 否 1 是
     */
    private String isIn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String itemName;
    @TableField(exist = false)
    private String storeName;
}