package com.example.shop.DAO.order;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO {
    private static final String INSERT_STATUS_SQL = "INSERT INTO status (status) VALUES (?);";
    private static final String SELECT_STATUS_BY_ID = "select * from status where id =?";
    private static final String SELECT_ALL_STATUS= "select * from status";
    private static final String DELETE_STATUS_SQL = "delete from status where id = ?;";
    private static final String UPDATE_STATUS_SQL = "update status set status = ? where id = ?;";

    public StatusDAO() {
    }
    Connection connection = ConnectMySQL.getConnection();
    public void insertStatus(Status status) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATUS_SQL)) {
            preparedStatement.setString(1, status.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Status selectStatus(int id) {
        Status status = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATUS_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String st = rs.getString("status");
                status = new Status(id, st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Status> selectAllStatus() {
        List<Status> statusList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATUS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String st = rs.getString("status");
                statusList.add(new Status(id, st));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusList;
    }

    public boolean deleteStatus(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_STATUS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateStatus(Status status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_SQL);) {
            statement.setString(1, status.getStatus());
            statement.setInt(2, status.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
