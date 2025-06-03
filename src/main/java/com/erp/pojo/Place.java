package com.erp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产地
 * @TableName t_place
 */
@TableName(value ="t_place")
@Data
public class Place {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer placeId;

    /**
     * 
     */
    private String placeName;

    /**
     * 
     */
    private String placeNum;

    /**
     * 
     */
    private String introduce;

    /**
     * 0:可用  1:不可用
     */
    private String isDelete;
}