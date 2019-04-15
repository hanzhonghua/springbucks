package com.springboot.springbucks.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: order
 * @author: HanZhonghua
 * @create: 2019-03-10 21:11
 */
public class Order implements Serializable {

    private Long orderId;
    private String customer;
    private Date createTime;
    private Date updateTime;
    private Integer orderStatus;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
