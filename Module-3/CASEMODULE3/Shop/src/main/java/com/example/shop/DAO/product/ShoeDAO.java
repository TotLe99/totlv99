package com.example.shop.DAO.product;

import com.example.shop.DAO.ConnectMySQL;

import com.example.shop.model.Shoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoeDAO {
    private static final String INSERT_SHOE_SQL = "INSERT INTO shoes (image_id,name,description,time,price) VALUES (?,?,?,?,?);";
    private static final String SELECT_SHOE_BY_ID = "select * from shoes where id =?";
    private static final String SELECT_SHOE_BY_NAME = "select * from shoes where name =?";
    private static final String SELECT_ALL_SHOE= "select * from shoes";
    private static final String DELETE_SHOE_SQL = "delete from shoes where id = ?;";
    private static final String UPDATE_SHOE_SQL = "update shoes set image_id = ?,name = ?,description = ?,time = ?, price = ? where id = ?;";

    public ShoeDAO() {
    }
    Connection connection = ConnectMySQL.getConnection();
    public void insertShoe(Shoe shoe) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOE_SQL)) {
            preparedStatement.setInt(1, shoe.getImage_id());
            preparedStatement.setString(2, shoe.getName());
            preparedStatement.setString(3, shoe.getDescription());
            preparedStatement.setString(4, shoe.getTime());
            preparedStatement.setFloat(5, shoe.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Shoe selectShoe(int id) {
        Shoe shoe = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOE_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int image_id = rs.getInt("image_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String time = rs.getString("time");
                float price = rs.getFloat("price");
                shoe = new Shoe(id, image_id, name, description, time, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoe;
    }

    public List<Shoe> selectAllShoe() {
        List<Shoe> shoes = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHOE);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int image_id = rs.getInt("image_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String time = rs.getString("time");
                float price = rs.getFloat("price");
                shoes.add(new Shoe(id,image_id,name, description, time, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoes;
    }

    public boolean deleteShoe(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SHOE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateShoe(Shoe shoe) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SHOE_SQL);) {
            statement.setInt(1, shoe.getImage_id());
            statement.setString(2, shoe.getName());
            statement.setString(3, shoe.getDescription());
            statement.setString(4, shoe.getTime());
            statement.setFloat(5, shoe.getPrice());
            statement.setInt(6, shoe.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public Shoe selectShoe(String name) {
        Shoe shoe = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOE_BY_NAME);) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int image_id = rs.getInt("image_id");
                String description = rs.getString("description");
                String time = rs.getString("time");
                float price = rs.getFloat("price");
                shoe = new Shoe(id, image_id, name, description, time, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoe;
    }
}
