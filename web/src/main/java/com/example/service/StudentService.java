package com.example.service;


import com.example.dao.tables.pojos.Student;

import java.util.List;

/**
 * @author gaoyang
 * @email 785175323@qq.com
 */
public interface StudentService {
    List<Student> list();

    Student one(Integer id);
}
