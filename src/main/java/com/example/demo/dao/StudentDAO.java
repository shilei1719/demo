package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author Ray
 * @date 2018/10/23 10:43
 *
 * 数据接入层
 */
@Mapper
public interface StudentDAO {
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
