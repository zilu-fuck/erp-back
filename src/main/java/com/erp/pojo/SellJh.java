package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName t_sell_jh
 */
@TableName(value ="t_sell_jh")
@Data
public class SellJh {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer custId;

    /**
     * 
     */
    private Integer channelId;

    /**
     * 
     */
    private Double money;

    /**
     * 
     */
    private String nowStep;

    /**
     * 
     */
    private Integer empId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String custName;
}