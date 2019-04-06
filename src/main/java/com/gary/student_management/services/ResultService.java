package com.gary.student_management.services;

import com.gary.student_management.constants.StudentEnum;
import com.gary.student_management.domains.Student;
import com.gary.student_management.results.HttpResult;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ResultService {

    public HttpResult returnGetResult(List<Student> list){
            if(list != null && list.size() > 0 ){
                return new HttpResult(StudentEnum.SUCCESS.getCode(),
                        StudentEnum.SUCCESS.getMessage(), list);
            }else{
                return new HttpResult(StudentEnum.NOT_FOUND.getCode(),
                        StudentEnum.NOT_FOUND.getMessage());
            }
    }

    public HttpResult returnPostResult(List<Student> list){
        if(list != null && list.size() > 0 ){
            return new HttpResult(StudentEnum.SUCCESS.getCode(),
                    StudentEnum.SUCCESS.getMessage(), list);
        }else{
            return new HttpResult(StudentEnum.ERROR.getCode(),
                    StudentEnum.ERROR.getMessage());
        }
    }

    public HttpResult returnDeleteResult(List<Student> list){
        if(list == null || list.size() == 0){
            return new HttpResult(StudentEnum.DELETE_SUCCESS.getCode(),
                    StudentEnum.DELETE_SUCCESS.getMessage());
        }else{
            return new HttpResult(StudentEnum.DELETE_FAIL.getCode(),
                    StudentEnum.DELETE_FAIL.getMessage());
        }
    }

    public HttpResult returnOtherResult(){
        return new HttpResult(StudentEnum.REQUEST_ERROR.getCode(),
                StudentEnum.REQUEST_ERROR.getMessage());
    }
}
