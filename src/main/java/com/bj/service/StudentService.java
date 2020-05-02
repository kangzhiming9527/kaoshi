package com.bj.service;

import com.bj.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> list(Student model, Pageable pageable);

    Student save(Student model);

    void deleteById(Integer id);

    Student getOne(Integer id);

}
