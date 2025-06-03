package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName t_order
 */
@TableName(value ="t_order")
@Data
public class Order {
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
    private Integer itemId;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    /**
     * 
     */
    private String state;

    /**
     * 
     */
    private String payment;

    /**
     * 
     */
    private Double payMoney;

    private Integer num;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String custName;

    @TableField(exist = false)
    private String itemName;

    @TableField(exist = false)
    private Integer pageNum=1;
    @TableField(exist = false)
    private Integer pageSize=3;
}