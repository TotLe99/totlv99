package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMySQL {
    static final String URL = "jdbc:mysql://localhost:3306/testmodule3?useSSL=false";
    static final String USERNAME = "root";
    static final String PASSWORD = "vjpnhats88";

    public static Connection getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }
}
