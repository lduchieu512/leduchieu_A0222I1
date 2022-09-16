package repository.impl;

import model.Student;
import repository.BaseRepository;
import repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String SELECT_ALL="select * from student;";
    private final String SEARCH="call search(?,?,?);";
    private final String DELETE_BY_ID=" delete from student where id =?;";
    private final String ADD_NEW ="insert into student(`name`, gender,birthday,`point`,`account`,class_id,email) values (?,?,?,?,?,?,?);";

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> studentList =new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String birthday = rs.getString("birthday");
                int point = rs.getInt("point");
                String account = rs.getString("account");
                String email = rs.getString("email");
                int classId = rs.getInt("classId");
                Student student = new Student(id,name,gender,birthday,point,account,classId,email);
                studentList.add(student);
            }

        return studentList;
    }

    @Override
    public Student findBy(int id) throws SQLException {
        return null;
    }

    @Override
    public void add(Student student) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();

            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getGender());
            preparedStatement.setDate(3, Date.valueOf(student.getBirthday()));
            preparedStatement.setInt(4,student.getPoint());
            preparedStatement.setInt(5,student.getClassId());
            preparedStatement.setString(6,student.getEmail());
            preparedStatement.setString(7,student.getAccount());
            preparedStatement.executeUpdate();

    }
}
