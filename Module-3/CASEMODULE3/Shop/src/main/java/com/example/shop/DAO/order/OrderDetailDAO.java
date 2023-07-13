package com.example.shop.DAO.order;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {
    private static final String INSERT_ORDERDETAIL_SQL = "INSERT INTO orderdetail (order_id,shoedetail_id,quantity_buy) VALUES (?,?,?);";
    private static final String SELECT_ORDERDETAIL_BY_ID = "select * from orderdetail where id =?";
    private static final String SELECT_ORDERDETAIL_BY_ORDER_ID = "select * from orderdetail where order_id =?";
    private static final String SELECT_ALL_ORDERDETAIL = "select * from orderdetail";
    private static final String DELETE_ORDERDETAIL_SQL = "delete from orderdetail where id = ?;";
    private static final String UPDATE_ORDERDETAIL_SQL = "update orderdetail set order_id = ?,shoedetail_id = ?,quantity_buy = ? where id = ?;";

    public OrderDetailDAO() {
    }

    Connection connection = ConnectMySQL.getConnection();
    public void insertOrderDetail(OrderDetail orderDetail) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERDETAIL_SQL)) {
            preparedStatement.setInt(1, orderDetail.getOrder_id());
            preparedStatement.setInt(2, orderDetail.getShoedetail_id());
            preparedStatement.setInt(3, orderDetail.getQuantity_buy());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public OrderDetail selectOrderDetail(int id) {
        OrderDetail orderDetail = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERDETAIL_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int shoedetail_id = rs.getInt("shoedetail_id");
                int quantity_buy = rs.getInt("quantity_buy");
                orderDetail = new OrderDetail(id, order_id, shoedetail_id, quantity_buy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetail;
    }

    public List<OrderDetail> selectAllOrderDetail() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERDETAIL);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int order_id = rs.getInt("order_id");
                int shoedetail_id = rs.getInt("shoedetail_id");
                int quantity_buy = rs.getInt("quantity_buy");
                orderDetails.add(new OrderDetail(id, order_id, shoedetail_id, quantity_buy));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    public boolean deleteOrderDetail(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ORDERDETAIL_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateOrderDetail(OrderDetail orderDetail) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDERDETAIL_SQL);) {
            statement.setInt(1, orderDetail.getOrder_id());
            statement.setInt(2, orderDetail.getShoedetail_id());
            statement.setInt(3, orderDetail.getQuantity_buy());

            statement.setInt(4, orderDetail.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<OrderDetail> selectOrderDetailByOrderId(int order_id) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERDETAIL_BY_ORDER_ID);) {
            preparedStatement.setInt(1, order_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int shoedetail_id = rs.getInt("shoedetail_id");
                int quantity_buy = rs.getInt("quantity_buy");
                orderDetails.add(new OrderDetail(id, order_id, shoedetail_id, quantity_buy));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }
}
