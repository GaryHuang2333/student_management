
package com.gary.student_management.services;

import com.gary.interview.job_puzzle.threadlocal.MyThreadLocal;
import com.gary.student_management.domains.Student;
import com.gary.student_management.repositories.StudentRepository;
import com.gary.student_management.results.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ResultService resultService;
    @Autowired
    private MockStudentService mockStudentService;

    public HttpResult findAll(){
        List<Student> studentList = studentRepository.findAll();
        String testThreadLocal = MyThreadLocal.testThreadLocal.get();
        System.out.println("testThreadLocal= " + testThreadLocal);
        return resultService.returnGetResult(studentList);
    }

    public HttpResult createByMock(){
        List<Student> studentList = studentRepository.saveAll(mockStudentService.createList());
        return resultService.returnPostResult(studentList);
    }

    public HttpResult deleteAll(){
        studentRepository.deleteAll();
        List<Student> studentList = studentRepository.findAll();
        return resultService.returnDeleteResult(studentList);
    }
}
