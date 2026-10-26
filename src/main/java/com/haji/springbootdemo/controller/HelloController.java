package com.haji.springbootdemo.controller;

import com.haji.springbootdemo.entity.Student;
import com.haji.springbootdemo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @PostMapping("/student/add")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "新增成功！name=" + student.getName();
    }


    // 注入service对象
    private final StudentService studentService;
    public HelloController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 查询全部
    @GetMapping("/student/list")
    public List<Student> list(){
        return studentService.listAll();
    }

    // 根据id查询
    @GetMapping("/student/getById")
    public Student getById(@RequestParam Integer id){
        return studentService.getById(id);
    }

    @GetMapping("/student/{sid}")
    public Student getByPathId(@PathVariable Integer sid){
        return studentService.getById(sid);
    }

    @GetMapping("/happy")
    public String happy(@RequestParam String msg){
        return msg;
    }
}
