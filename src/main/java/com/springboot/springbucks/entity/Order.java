package com.springboot.springbucks.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: coffee
 * @author: HanZhonghua
 * @create: 2019-03-10 21:11
 */
public class Order implements Serializable {

    private Integer id;
    private String customer;
    private Integer state;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
