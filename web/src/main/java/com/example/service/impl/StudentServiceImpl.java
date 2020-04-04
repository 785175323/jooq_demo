package com.example.service.impl;

import com.example.dao.tables.daos.StudentDao;
import com.example.dao.tables.pojos.Student;
import com.example.service.StudentService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoyang
 * @email 785175323@qq.com
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private DSLContext dslContext;

    @Override
    public List<Student> list() {
        return studentDao.findAll();
    }

    @Override
    public Student one(Integer id) {
        return dslContext.select().
                from(com.example.dao.tables.Student.STUDENT).
                where(com.example.dao.tables.Student.STUDENT.ID.eq(id)).
                fetchOneInto(Student.class);
    }

    @Override
    public void delete(List<Integer> id) {
        studentDao.deleteById(id);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public Integer insert(Student student) {
        // dslContext.newRecord(com.example.dao.tables.Student.STUDENT, student).insert();
        studentDao.insert(student);
        return student.getId();
    }
}
