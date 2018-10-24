package com.example.demo.web;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ray
 * @date 2018/10/23 10:52
 *
 * 控制层
 */
@RestController
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentService studentService;

    /**
     * 获取所有学生信息
     * @return
     */
    @PostMapping(value = "/getAll")
    public List<Student> getAllStudents(){
        logger.info("获取所有学生信息");
        return studentService.getAllStudents();
    }

    /**
     * 条件查询学生信息
     * @param student
     * @return
     */
    @PostMapping(value = "/searchStudent")
    public List<Student> searchStudent(@RequestBody Student student){
        logger.info("获取某个学生信息："+student);
        return studentService.searchStudents(student);
    }

    /**
     * 新增学生信息
     * @return
     */
    @PostMapping(value = "/addStudent")
    public int addStudent(@RequestBody Student student){
        logger.info("新增学生信息:"+student);
        return studentService.addStudent(student);
    }

    /**
     * 删除学生信息
     * @return
     */
    @PostMapping(value = "/deleteStudent")
    public int deleteStudent(@RequestBody List<String> studentNo){
        logger.info("删除学生信息:"+studentNo);
        return studentService.deleteStudent(studentNo);
    }

    /**
     * 修改学生信息
     * @return
     */
    @PostMapping(value = "/updateStudent")
    public int updateStudent(@RequestBody Student student){
        logger.info("修改学生信息:"+student);
        return studentService.updateStudent(student);
    }


}
