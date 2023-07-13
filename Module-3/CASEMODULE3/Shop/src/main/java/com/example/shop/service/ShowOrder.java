package com.example.shop.service;

import com.example.shop.model.OrderDetail;
import com.example.shop.model.Shoe;
import com.example.shop.model.view.ViewShoeDetail;

import java.util.List;

public class ShowOrder {
    private int order_id;
    private float total_amount;
    private List<ViewShoeDetail> viewShoeDetailList;
    private int status_id;

    public ShowOrder() {
    }

    public ShowOrder(int order_id, List<ViewShoeDetail> viewShoeDetailList, float total_amount, int status_id) {
        this.order_id = order_id;
        this.total_amount = total_amount;
        this.viewShoeDetailList = viewShoeDetailList;
        this.status_id = status_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public List<ViewShoeDetail> getViewShoeDetailList() {
        return viewShoeDetailList;
    }

    public void setViewShoeDetailList(List<ViewShoeDetail> viewShoeDetailList) {
        this.viewShoeDetailList = viewShoeDetailList;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
