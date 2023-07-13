package dao;

import model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClassDAO {
    Connection connection = ConnectMySQL.getConnect();

    public Class getClass(String name) {
        try {
            String sql = "select * from `class` where `name`= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int id = resultSet.getInt("id");
            return new Class(id,name);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
