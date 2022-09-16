package repository;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll() throws SQLException;
    Student findBy(int id) throws SQLException;
    void add(Student student) throws SQLException;
}
