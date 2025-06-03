package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 入库单
 * @TableName t_in_store
 */
@TableName(value ="t_in_store")
@Data
public class InStore {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer insId;

    /**
     * 
     */
    private Integer storeId;

    /**
     * 
     */
    private Integer productId;

    /**
     * 
     */
    private Integer inNum;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 0 否 1 是
     */
    private String isIn;//0未确认，1已确认

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String storeName;

    @TableField(exist = false)
    private String itemName;
}