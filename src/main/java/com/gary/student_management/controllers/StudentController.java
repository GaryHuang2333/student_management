package com.gary.student_management.controllers;

        import com.gary.student_management.results.HttpResult;
        import com.gary.student_management.services.ResultService;
        import com.gary.student_management.services.StudentService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ResultService resultService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello to Student management";
    }

    @GetMapping("/get_all")
    public HttpResult getAll(){
        return studentService.findAll();
    }

    @PostMapping("/create_all")
    public HttpResult createAll(){
        return studentService.createByMock();
    }

    @DeleteMapping("/delete_all")
    public HttpResult deleteAll(){
        return studentService.deleteAll();
    }

    @RequestMapping("/*")
    public HttpResult otherRequest(){
        return resultService.returnOtherResult();
    }

    @PostMapping("/hello")
    public HttpResult helloWithParam(@RequestParam("id") Integer id){
        return new HttpResult(200, "id="+id, null);
    }

}


