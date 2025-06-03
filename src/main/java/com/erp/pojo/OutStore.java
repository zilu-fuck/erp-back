package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 出库单
 * @TableName t_out_store
 */
@TableName(value ="t_out_store")
@Data
public class OutStore {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer outsId;

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
    private Integer tallyId;

    /**
     * 
     */
    private BigDecimal outPrice;

    /**
     * 
     */
    private Integer outNum;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    private Date createTime;

    /**
     * 0 否 1 是
     */
    private String isOut;
}