package com.example.shop.DAO.view;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.Account;
import com.example.shop.model.view.ViewShoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewShoeDAO {
    private static final String SELECT_VIEWSHOE = "select shoes.id, shoes.name, shoes.price, images.url from shoes inner join images on shoes.image_id = images.id;";
    private static final String SELECT_VIEWSHOE_BYID = "select shoes.id, shoes.name, shoes.price, images.url from shoes inner join images on shoes.image_id = images.id where shoes.id = ?;";
    public ViewShoeDAO() {
    }

    Connection connection = ConnectMySQL.getConnection();
    public List<ViewShoe> selectAllShoe() {
        List<ViewShoe> viewShoes = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VIEWSHOE);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String url = rs.getString("url");

                viewShoes.add(new ViewShoe(id, name, price, url));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewShoes;
    }
    public ViewShoe selectViewShoeById(int id) {
        ViewShoe viewShoe = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VIEWSHOE_BYID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String url = rs.getString("url");

                viewShoe = new ViewShoe(id, name, price, url);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewShoe;
    }
}
