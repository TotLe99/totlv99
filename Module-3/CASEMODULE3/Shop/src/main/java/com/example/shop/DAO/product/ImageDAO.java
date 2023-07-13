package com.example.shop.DAO.product;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {
    private static final String INSERT_IMG_SQL = "INSERT INTO images (url) VALUES (?);";
    private static final String SELECT_IMG_BY_ID = "select * from images where id =?";
    private static final String SELECT_ALL_IMG= "select * from images";
    private static final String DELETE_IMG_SQL = "delete from images where id = ?;";
    private static final String UPDATE_IMG_SQL = "update images set url = ? where id = ?;";

    public ImageDAO() {
    }
    Connection connection = ConnectMySQL.getConnection();
    public void insertImage(Image image) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IMG_SQL)) {
            preparedStatement.setString(1, image.getUrl());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Image selectImage(int id) {
        Image image = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IMG_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String url = rs.getString("url");
                image = new Image(id, url);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }

    public List<Image> selectAllImage() {
        List<Image> images = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMG);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String url = rs.getString("url");
                images.add(new Image(id, url));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    public boolean deleteImage(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_IMG_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateImage(Image image) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_IMG_SQL);) {
            statement.setString(1, image.getUrl());
            statement.setInt(2, image.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
