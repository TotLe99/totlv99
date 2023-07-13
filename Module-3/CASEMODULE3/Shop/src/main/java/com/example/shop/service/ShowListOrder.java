package com.example.shop.service;

import com.example.shop.DAO.order.OrderDAO;
import com.example.shop.DAO.order.OrderDetailDAO;
import com.example.shop.DAO.product.ShoeDAO;
import com.example.shop.DAO.product.ShoeDetailDAO;
import com.example.shop.DAO.view.ViewShoeDetailDAO;
import com.example.shop.model.Order;
import com.example.shop.model.OrderDetail;
import com.example.shop.model.Shoe;
import com.example.shop.model.ShoeDetail;
import com.example.shop.model.view.ViewShoeDetail;

import java.util.ArrayList;
import java.util.List;

public class ShowListOrder {
    private List<ShowOrder> showOrderList = new ArrayList<>();
    OrderDAO orderDAO = new OrderDAO();
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    ShoeDAO shoeDAO = new ShoeDAO();
    ShoeDetailDAO shoeDetailDAO = new ShoeDetailDAO();
    ViewShoeDetailDAO viewShoeDetailDAO = new ViewShoeDetailDAO();
    List<Order> orderList = orderDAO.selectAllOrder();
    public ShowListOrder() {
        for (Order order : orderList) {
            List<OrderDetail> orderDetailList = orderDetailDAO.selectOrderDetailByOrderId(order.getId());
            List<ViewShoeDetail> viewShoeDetailList = new ArrayList<>();
            for (OrderDetail orderDetail : orderDetailList) {
                ViewShoeDetail viewShoeDetail = viewShoeDetailDAO.selectViewShoeDetailByOrderId(orderDetail.getOrder_id(), orderDetail.getShoedetail_id());
                viewShoeDetailList.add(viewShoeDetail);
            }
            showOrderList.add(new ShowOrder(order.getId(), viewShoeDetailList, order.getTotal_amount(),order.getStatus_id()));
        }
    }

    public List<ShowOrder> getShowOrderList() {
        return showOrderList;
    }

    public void setShowOrderList(List<ShowOrder> showOrderList) {
        this.showOrderList = showOrderList;
    }

    public static void main(String[] args) {
        ShowListOrder showListOrder = new ShowListOrder();
        List<ShowOrder> showOrders = showListOrder.getShowOrderList();
        System.out.println(showOrders);
    }
}
