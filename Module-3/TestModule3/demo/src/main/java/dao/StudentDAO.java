package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection connection = ConnectMySQL.getConnect();

    public List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        try {
            String sql = "select * from student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("ids");
                String name = resultSet.getString("name");
                LocalDate dateOfBirth = resultSet.getDate("dateofbirth").toLocalDate();
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                students.add(new Student(id,name,dateOfBirth,email,address,phone));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public void save(Student student){
        try {
            String sql = "insert into student(name,dateOfBirth,email,address,phone) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setObject(2,student.getDateOfBirth());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getPhone());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
