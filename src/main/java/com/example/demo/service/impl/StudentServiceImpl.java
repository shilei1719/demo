package com.example.demo.service.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ray
 * @date 2018/10/23 10:49
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public List<Student> searchStudents(Student student) {
        return studentDAO.searchStudents(student);
    }

    @Override
    public int addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    @Override
    public int deleteStudent(List<String> studentNo) {
        return studentDAO.deleteStudent(studentNo);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }
}
