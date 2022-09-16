package service.impl;


import common.Validation;
import model.Student;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import service.IStudentSevice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSevice implements IStudentSevice {
    private IStudentRepository studentRepository =new StudentRepository();

    @Override
    public List<Student> findAll() throws SQLException {
        return studentRepository.findAll();
    }

    @Override
    public Student findBy(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean add(Student student) throws SQLException {
        Map<String,String> map = new HashMap<>();
        if (student.getPoint()<0){
            map.put("point","diem phai lon hon 0");
        }else if (student.getPoint()>10){
            map.put("point","diem phai nho hon 10");
        }
        if ("".equals(student.getEmail())){
            map.put("email","Email khong duoc de trong");
        }else if(!Validation.checkEmail(student.getEmail())){
            map.put("email","Email ko dung dinh dang");
        }
        if (map.isEmpty()){
            studentRepository.add(student);
        }
        return false;
    }
}
