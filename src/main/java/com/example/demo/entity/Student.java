package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Ray
 * @date 2018/10/23 10:24
 *
 * 学生信息实体类
 */
@Entity
public class Student {
    /** 自增主键id **/
    @Id
    private Integer id;
    /** 学生姓名 **/
    private String name;
    /** 学号 **/
    private String studentNo;
    /** 专业 **/
    private String major;
    /** 入学时间 **/
    private String enrollmentDate;
    /** 是否删除 y/n**/
    private String isDelete;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", major='" + major + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
