package com.example.web;

import com.example.dao.tables.pojos.Student;
import com.example.service.StudentService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gaoyang
 * @email 785175323@qq.com
 */
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    DSLContext dslContext;

    @GetMapping("list")
    public List<Student> list() {
        return studentService.list();
    }

    @GetMapping("one")
    public Student one(Integer id){
        return studentService.one(id);
    }
}
