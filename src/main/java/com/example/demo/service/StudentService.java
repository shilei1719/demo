package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

/**
 * @author Ray
 * @date 2018/10/23 10:47
 *
 * 业务接口层
 */
public interface StudentService {
    /**
     * 获取所有学生信息
     * @return
     */
    List<Student> getAllStudents();

    /**
     * 条件查询学生信息
     * @param student
     * @return
     */
    List<Student> searchStudents(Student student);

    /**
     * 新增学生信息
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 删除学生信息
     * @param studentNo
     * @return
     */
    int deleteStudent(List<String> studentNo);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    int updateStudent(Student student);
}
