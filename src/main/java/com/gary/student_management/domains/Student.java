package com.gary.student_management.domains;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, unique = true)
    private Integer no;
    @Column(nullable = false, length = 10)
    private String name;
    @Min(value = 6, message = "Min age for school is 6")
    @Max(value = 13, message = "Max age for school is 13")
    private Integer age;
    @Column(length = 1)
    private String gender;
    private Integer classNo;
    private String misc;

    public Student() {
    }

    public Student(Integer no, String name, @Min(value = 6, message = "Min age for school is 6") @Max(value = 13, message = "Max age for school is 13") Integer age, String gender, Integer classNo, String misc) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.classNo = classNo;
        this.misc = misc;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", classNo=" + classNo +
                ", misc='" + misc + '\'' +
                '}';
    }
}
