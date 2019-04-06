package com.gary.student_management.services;

import com.gary.student_management.domains.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MockStudentService {


    public List<Student> createList(){
        List<Student> studentList = new ArrayList<>();
        Student[] stuArray = {
                new Student(1,"Tommy",6,"M",1,"mock data"),
                new Student(2,"Lily",7,"F",2,"mock data"),
                new Student(3,"Jacky",6,"M",1,"mock data"),
                new Student(4,"Jimmy",8,"M",3,"mock data"),
                new Student(5,"Wendy",6,"F",1,"mock data"),
                new Student(6,"Shirley",10,"F",5,"mock data")
        };
        studentList = Arrays.asList(stuArray);

        return studentList;
    }
}
