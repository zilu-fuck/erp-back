package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 仓库表
 * @TableName t_store
 */
@TableName(value ="t_store")
@Data
public class Store {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer storeId;

    /**
     * 
     */
    private String storeName;

    /**
     * 
     */
    private String storeNum;

    /**
     * 
     */
    private String storeAddress;

    /**
     * 
     */
    private String concat;

    /**
     * 
     */
    private String phone;
}