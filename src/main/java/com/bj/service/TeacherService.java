package com.bj.service;

import com.alibaba.fastjson.JSONArray;
import com.bj.bean.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Page<Teacher> list(Teacher model, Pageable pageable);

    Teacher save(Teacher model);

    void deleteById(Integer id);

    Teacher getOne(Integer id);

    JSONArray studentTree(Integer tid);
}
