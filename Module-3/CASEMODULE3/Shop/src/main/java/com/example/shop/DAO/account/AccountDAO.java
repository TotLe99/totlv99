package com.example.shop.DAO.account;

import com.example.shop.DAO.ConnectMySQL;
import com.example.shop.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountDAO {
    private static final String INSERT_ACCOUNT_SQL = "INSERT INTO accounts (name,gender,birthday,phone,address, email, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ACCOUNT_BY_ID = "select * from accounts where id =?";
    private static final String SELECT_ACCOUNT_BY_EMAIL_PASSWORD = "select * from accounts where email = ? and password = ?";
    private static final String SELECT_ALL_ACCOUNT = "select * from accounts";
    private static final String DELETE_ACCOUNT_SQL = "delete from accounts where id = ?;";
    private static final String UPDATE_ACCOUNT_SQL = "update accounts set name = ?,gender = ?,birthday = ?,phone = ?, address = ?, email = ?, password = ? where id = ?;";

    public AccountDAO() {
    }

    Connection connection = ConnectMySQL.getConnection();

    public void insertAccount(Account account) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL)) {
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getGender());
            preparedStatement.setString(3, account.getBirthday());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setString(5, account.getAddress());
            preparedStatement.setString(6, account.getEmail());
            preparedStatement.setString(7, account.getPassword());
            preparedStatement.setString(8, account.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Account selectAccount(int id) {
        Account account = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String birthday = rs.getString("birthday");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                account = new Account(id, name, gender, birthday, phone, address, email, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> selectAllAccount() {
        List<Account> accounts = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String birthday = rs.getString("birthday");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                accounts.add(new Account(id, name, gender, birthday, phone, address, email, password, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public boolean deleteAccount(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ACCOUNT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateAccount(Account account) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT_SQL);) {
            statement.setString(1, account.getName());
            statement.setString(2, account.getGender());
            statement.setString(3, account.getBirthday());
            statement.setString(4, account.getPhone());
            statement.setString(5, account.getAddress());
            statement.setString(6, account.getEmail());
            statement.setString(7, account.getPassword());
            statement.setInt(8, account.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public Account selectAccount(String email, String password) {
        Account account = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL_PASSWORD);) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String birthday = rs.getString("birthday");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String role = rs.getString("role");
                account = new Account(id, name, gender, birthday, phone, address, email, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
