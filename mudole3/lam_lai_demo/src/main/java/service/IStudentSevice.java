package service;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentSevice {
    List<Student> findAll() throws SQLException;
    Student findBy(int id) throws SQLException ;
    boolean add(Student student) throws  SQLException;
}
