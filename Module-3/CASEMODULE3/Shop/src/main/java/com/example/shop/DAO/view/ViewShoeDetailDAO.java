package com.example.shop.DAO.view;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.view.ViewShoeDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewShoeDetailDAO {
    private static final String SELECT_VIEWSHOEDETAIL = "select shoes.id, shoes.name, shoes.price, images.url, colors.code, sizes.size, orderdetail.quantity_buy\t\n" +
            "from shoes\n" +
            "inner join images on images.id = shoes.image_id\n" +
            "inner join shoedetail on shoedetail.shoe_id = shoes.id\n" +
            "inner join colors on shoedetail.color_id = colors.id\n" +
            "inner join sizes on shoedetail.size_id = sizes.id\n" +
            "inner join orderdetail on shoedetail.id = orderdetail.shoedetail_id;";
    private static final String SELECT_VIEWSHOEDETAIL_BYID = "select shoes.id, shoes.name, shoes.price, images.url, colors.code, sizes.size, orderdetail.quantity_buy\t\n" +
            "from shoes\n" +
            "inner join images on images.id = shoes.image_id\n" +
            "inner join shoedetail on shoedetail.shoe_id = shoes.id\n" +
            "inner join colors on shoedetail.color_id = colors.id\n" +
            "inner join sizes on shoedetail.size_id = sizes.id\n" +
            "inner join orderdetail on shoedetail.id = orderdetail.shoedetail_id where id = ?";
    private static final String SELECT_VIEWSHOEDETAIL_BYORDER_ID = "select shoes.id, shoes.name, shoes.price, images.url, colors.code, sizes.size, orderdetail.quantity_buy\t\n" +
            "from shoes\n" +
            "inner join images on images.id = shoes.image_id\n" +
            "inner join shoedetail on shoedetail.shoe_id = shoes.id\n" +
            "inner join colors on shoedetail.color_id = colors.id\n" +
            "inner join sizes on shoedetail.size_id = sizes.id\n" +
            "inner join orderdetail on shoedetail.id = orderdetail.shoedetail_id where orderdetail.order_id = ? and orderdetail.shoedetail_id = ?";
    public ViewShoeDetailDAO() {
    }

    Connection connection = ConnectMySQL.getConnection();
    public List<ViewShoeDetail> selectAllShoeDetail() {
        List<ViewShoeDetail> viewShoeDetails = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VIEWSHOEDETAIL);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String url = rs.getString("url");
                String code = rs.getString("code");
                int size = Integer.parseInt(rs.getString("size"));
                int quantity_buy = Integer.parseInt(rs.getString("quantity_buy"));

                viewShoeDetails.add(new ViewShoeDetail(id, name, price, url, code, size, quantity_buy));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewShoeDetails;
    }
    public ViewShoeDetail selectViewShoeDetailById(int id) {
        ViewShoeDetail viewShoeDetail = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VIEWSHOEDETAIL_BYID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String url = rs.getString("url");
                String code = rs.getString("code");
                int size = Integer.parseInt(rs.getString("size"));
                int quantity_buy = Integer.parseInt(rs.getString("quantity_buy"));

                viewShoeDetail = new ViewShoeDetail(id, name, price, url, code, size, quantity_buy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewShoeDetail;
    }
    public ViewShoeDetail selectViewShoeDetailByOrderId(int order_id, int shoedetail_id) {
        ViewShoeDetail viewShoeDetail = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VIEWSHOEDETAIL_BYORDER_ID);) {
            preparedStatement.setInt(1, order_id);
            preparedStatement.setInt(2, shoedetail_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String url = rs.getString("url");
                String code = rs.getString("code");
                int size = Integer.parseInt(rs.getString("size"));
                int quantity_buy = Integer.parseInt(rs.getString("quantity_buy"));

                viewShoeDetail = new ViewShoeDetail(id, name, price, url, code, size, quantity_buy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewShoeDetail;
    }
}
