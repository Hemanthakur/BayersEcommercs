package com.example.request;

import javax.validation.constraints.NotNull;

import com.example.model.Order;

public class OrderRequest {
    private Integer id;
    private @NotNull Integer userId;

    public OrderRequest() {
    }

    public OrderRequest(Order order) {
        this.setId(order.getId());
        //this.setUserId(order.getUserId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
