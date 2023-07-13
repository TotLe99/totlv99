package com.example.shop.DAO.blog;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {
    private static final String INSERT_BLOG_SQL = "INSERT INTO blogs (image_id,title,content) VALUES (?,?,?);";
    private static final String SELECT_BLOG_BY_ID = "select * from blogs where id =?";
    private static final String SELECT_ALL_BLOG= "select * from blogs";
    private static final String DELETE_BLOG_SQL = "delete from blogs where id = ?;";
    private static final String UPDATE_BLOG_SQL = "update blogs set image_id = ?,title = ?,content = ? where id = ?;";

    public BlogDAO() {
    }
    Connection connection = ConnectMySQL.getConnection();
    public void insertBlog(Blog blog) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BLOG_SQL)) {
            preparedStatement.setInt(1, blog.getImage_id());
            preparedStatement.setString(2, blog.getTitle());
            preparedStatement.setString(3, blog.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Blog selectBlog(int id) {
        Blog blog = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BLOG_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int image_id = rs.getInt("image_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                blog = new Blog(id, image_id, title, content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blog;
    }

    public List<Blog> selectAllBlog() {
        List<Blog> blogs = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BLOG);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int image_id = rs.getInt("image_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                blogs.add(new Blog(id, image_id, title, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogs;
    }

    public boolean deleteBlog(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BLOG_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateBlog(Blog blog) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_BLOG_SQL);) {
            statement.setInt(1, blog.getImage_id());
            statement.setString(2, blog.getTitle());
            statement.setString(3, blog.getContent());
            statement.setInt(4, blog.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
