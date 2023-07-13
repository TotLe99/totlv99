package com.example.shop.DAO.product;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.Size;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeDAO {
    private static final String INSERT_SIZE_SQL = "INSERT INTO sizes (size) VALUES (?);";
    private static final String SELECT_SIZE_BY_ID = "select * from sizes where id =?";
    private static final String SELECT_SIZE_BY_SIZE = "select * from sizes where size =?";
    private static final String SELECT_ALL_SIZE = "select * from sizes";
    private static final String DELETE_SIZE_SQL = "delete from sizes where id = ?;";
    private static final String UPDATE_SIZE_SQL = "update sizes set size = ? where id = ?;";

    public SizeDAO() {
    }
    Connection connection = ConnectMySQL.getConnection();
    public void insertSize(Size size) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SIZE_SQL)) {
            preparedStatement.setInt(1, size.getSize());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Size selectSize(int id) {
        Size size = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SIZE_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int sizeN = rs.getInt("size");
                size = new Size(id, sizeN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

    public List<Size> selectAllSize() {
        List<Size> sizes = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SIZE);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int sizeN = rs.getInt("size");
                sizes.add(new Size(id, sizeN));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizes;
    }

    public boolean deleteSize(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SIZE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateSize(Size size) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SIZE_SQL);) {
            statement.setInt(1, size.getSize());
            statement.setInt(2, size.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public Size selectSizeBySize(int sizeN) {
        Size size = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SIZE_BY_SIZE);) {
            preparedStatement.setInt(1, sizeN);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                size = new Size(id, sizeN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }
}
