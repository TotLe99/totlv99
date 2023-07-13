package com.example.shop.DAO.product;

import com.example.shop.DAO.ConnectMySQL;

import com.example.shop.model.ShoeDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoeDetailDAO {
    private static final String INSERT_SHOEDETAIL_SQL = "INSERT INTO shoedetail (shoe_id,color_id,size_id,quantity) VALUES (?,?,?,?);";
    private static final String SELECT_SHOEDETAIL_BY_ID = "select * from shoedetail where id =?";
    private static final String SELECT_SHOEDETAIL_BY_SHOEID_COLOR_SIZE = "select * from shoedetail where shoe_id =? and color_id = ? and size_id = ?";
    private static final String SELECT_ALL_SHOEDETAIL= "select * from shoedetail";
    private static final String DELETE_SHOEDETAIL_SQL = "delete from shoedetail where id = ?;";
    private static final String UPDATE_SHOEDETAIL_SQL = "update shoedetail set shoe_id = ?,color_id = ?,size_id = ?,quantity = ? where id = ?;";

    public ShoeDetailDAO() {
    }

    Connection connection = ConnectMySQL.getConnection();
    public void insertShoeDetail(ShoeDetail shoeDetail) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOEDETAIL_SQL)) {
            preparedStatement.setInt(1, shoeDetail.getShoe_id());
            preparedStatement.setInt(2, shoeDetail.getColor_id());
            preparedStatement.setInt(3, shoeDetail.getSize_id());
            preparedStatement.setInt(4, shoeDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ShoeDetail selectShoeDetail(int id) {
        ShoeDetail shoeDetail = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOEDETAIL_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int shoe_id = rs.getInt("shoe_id");
                int color_id = rs.getInt("color_id");
                int size_id = rs.getInt("size_id");
                int quantity = rs.getInt("quantity");
                shoeDetail = new ShoeDetail(id, shoe_id, color_id, size_id, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoeDetail;
    }

    public List<ShoeDetail> selectAllShoeDetail() {
        List<ShoeDetail> shoeDetails = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHOEDETAIL);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int shoe_id = rs.getInt("shoe_id");
                int color_id = rs.getInt("color_id");
                int size_id = rs.getInt("size_id");
                int quantity = rs.getInt("quantity");
                shoeDetails.add(new ShoeDetail(id, shoe_id, color_id, size_id, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoeDetails;
    }

    public boolean deleteShoeDetail(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SHOEDETAIL_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateShoeDetail(ShoeDetail shoeDetail) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SHOEDETAIL_SQL);) {
            statement.setInt(1, shoeDetail.getShoe_id());
            statement.setInt(2, shoeDetail.getColor_id());
            statement.setInt(3, shoeDetail.getSize_id());
            statement.setInt(4, shoeDetail.getQuantity());
            statement.setInt(5, shoeDetail.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public ShoeDetail selectShoeDetail(int shoe_id, int color_id, int size_id) {
        ShoeDetail shoeDetail = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOEDETAIL_BY_SHOEID_COLOR_SIZE);) {
            preparedStatement.setInt(1, shoe_id);
            preparedStatement.setInt(2, color_id);
            preparedStatement.setInt(3, size_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                shoeDetail = new ShoeDetail(id, shoe_id, color_id, size_id, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoeDetail;
    }
}
