package com.springboot.springbucks.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: coffee
 * @author: HanZhonghua
 * @create: 2019-03-10 21:11
 */
@Data  // get set toString
@Builder
public class Coffee implements Serializable {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Date createTime;
    private Date updateTime;

}
