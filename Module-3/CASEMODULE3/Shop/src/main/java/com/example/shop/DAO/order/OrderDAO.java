package com.example.shop.DAO.order;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static final String INSERT_ORDER_SQL = "INSERT INTO orders (user_id,date,total_amount,STATUS_ID) VALUES (?,?,?,?);";
    private static final String SELECT_ORDER_BY_ID = "select * from orders where id =?";
    private static final String SELECT_NEWORDER = "select * from orders ORDER BY id DESC LIMIT 1;";
    private static final String SELECT_ALL_ORDER= "select * from orders";
    private static final String DELETE_ORDER_SQL = "delete from orders where id = ?;";
    private static final String UPDATE_ORDER_SQL = "update orders set user_id = ?,date = ?,total_amount = ?,STATUS_ID = ? where id = ?;";
    public OrderDAO() {
    }
    Connection connection = ConnectMySQL.getConnection();
    public void insertOrder(Order order) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
            preparedStatement.setInt(1, order.getUser_id());
            preparedStatement.setString(2, order.getDate());
            preparedStatement.setFloat(3, order.getTotal_amount());
            preparedStatement.setInt(4, order.getStatus_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Order selectOrder(int id) {
        Order order = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String date = rs.getString("date");
                float total_amount = rs.getFloat("total_amount");
                int status_id = rs.getInt("status_id");
                order = new Order(id, user_id, date, total_amount, status_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public List<Order> selectAllOrder() {
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String date = rs.getString("date");
                float total_amount = rs.getFloat("total_amount");
                int status_id = rs.getInt("status_id");
                orders.add(new Order(id, user_id, date, total_amount, status_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public boolean deleteOrder(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateOrder(Order order) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL);) {
            statement.setInt(1, order.getUser_id());
            statement.setString(2, order.getDate());
            statement.setFloat(3, order.getTotal_amount());
            statement.setInt(4, order.getStatus_id());
            statement.setInt(5, order.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public Order selectNewOrder() {
        Order order = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEWORDER);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String date = rs.getString("date");
                float total_amount = rs.getFloat("total_amount");
                int status_id = rs.getInt("status_id");
                order = new Order(id, user_id, date, total_amount, status_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
