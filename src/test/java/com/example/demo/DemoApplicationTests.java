package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    StudentService studentService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getAllTest(){
        System.out.println(studentService.getAllStudents());
    }

    @Test
    public void addStudentTest(){
        Student student = new Student();
        student.setStudentNo("M201676120");
        student.setMajor("经济学");
        student.setEnrollmentDate("2018-09-01");
        System.out.println(studentService.addStudent(student));
    }

    @Test
    public void deleteStudentTest(){
        List<String> list = new ArrayList<>();
        list.add("M201676001");
        list.add("M201676002");

        System.out.println(studentService.deleteStudent(list));
    }

    @Test
    public void updateStudentTest(){
        Student student = new Student();
        student.setStudentNo("M201676002");
        student.setMajor("经济学");
        student.setEnrollmentDate("2012-11-11");
        System.out.println(studentService.updateStudent(student));
    }

    @Test
    public void searchStudentTest(){
        Student student = new Student();
        //student.setName("张");
        //student.setMajor("经济");
        System.out.println(studentService.searchStudents(student));
    }

}
