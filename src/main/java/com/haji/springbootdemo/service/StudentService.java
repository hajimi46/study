package com.haji.springbootdemo.service;

import com.haji.springbootdemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    // 模拟数据库，内存存学生数据
    private List<Student> db = new ArrayList<>();

    // 构造方法，初始化几条数据
    public StudentService(){
        db.add(new Student(1,"张三",19));
        db.add(new Student(2,"李四",20));
        db.add(new Student(3,"王五",18));
    }

    // 查询全部学生
    public List<Student> listAll(){
        return db;
    }

    // 根据id查询单个学生
    public Student getById(Integer id){
        for (Student s : db) {
            if(s.getId().equals(id)){
                return s;
            }
        }
        return new Student(99,"未知学生",0);
    }

    // 新增学生
    public boolean addStudent(Student student){
        db.add(student);
        return true;
    }
}
