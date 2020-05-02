package com.bj.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bj.bean.Student;
import com.bj.bean.Teacher;
import com.bj.dao.StudentDao;
import com.bj.dao.TeacherDao;
import com.bj.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TeacherServiceImpl：
 * 2020/3/28 9:06
 * by kzm
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao dao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public Page<Teacher> list(Teacher model, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withIgnorePaths("creationTime")
                .withIgnorePaths("updateTime")
                .withIgnorePaths("type0")
                .withIgnorePaths("school")
                .withIgnorePaths("grade")//暂时忽略知识点查询
                .withIgnorePaths("id");//忽略字段，即不管password是什么值都不加入查询条件
        Example<Teacher> ex = Example.of(model,matcher); //动态查询
        return dao.findAll(ex,pageable);
    }

    @Override
    public Teacher save(Teacher model) {
        return dao.save(model);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Teacher getOne(Integer id) {
        return dao.getOne(id);
    }

    @Override
    public JSONArray studentTree(Integer tid) {
        List<Student> students = studentDao.findAll();
       //写递归形成学生树
        return null;
    }


}
