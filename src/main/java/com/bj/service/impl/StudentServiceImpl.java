package com.bj.service.impl;

import com.bj.bean.Questions;
import com.bj.bean.Student;
import com.bj.dao.StudentDao;
import com.bj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * StudentServiceImpl：
 * 2020/3/28 9:06
 * by kzm
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao dao;
    @Override
    public Page<Student> list(Student model, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withIgnorePaths("creationTime")
                .withIgnorePaths("updateTime")
                .withIgnorePaths("parent")
                .withIgnorePaths("phone")
                .withIgnorePaths("grade")
                .withIgnorePaths("school")//暂时忽略知识点查询
                .withIgnorePaths("id");//忽略字段，即不管password是什么值都不加入查询条件
        Example<Student> ex = Example.of(model,matcher); //动态查询
        return dao.findAll(ex,pageable);
    }

    @Override
    public Student save(Student model) {
        return dao.save(model);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Student getOne(Integer id) {
        return dao.getOne(id);
    }
}
