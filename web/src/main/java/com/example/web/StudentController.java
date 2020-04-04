package com.example.web;

import com.example.dao.tables.pojos.Student;
import com.example.service.StudentService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Student> list() {
        return studentService.list();
    }

    @GetMapping("{id}")
    public Student one(@PathVariable Integer id) {
        return studentService.one(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable List<Integer> id) {
        studentService.delete(id);
    }

    @PutMapping
    public void update(Student student) {
        studentService.update(student);
    }

    @PostMapping
    public Integer insert(Student student) {
        return studentService.insert(student);
    }

}
