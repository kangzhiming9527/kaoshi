package com.bj.service.impl;

import com.bj.bean.Questions;
import com.bj.dao.QuestionsDao;
import com.bj.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * QuestionsServiceImpl：
 * 2020/2/23 20:41
 * by kzm
 */
@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    private QuestionsDao dao;

    /**
     * 列表分页查询
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<Questions> list(Questions model,Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("content" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withIgnorePaths("creationTime")
                .withIgnorePaths("updateTime")
                .withIgnorePaths("knowledge")//暂时忽略知识点查询
                .withIgnorePaths("id");//忽略字段，即不管password是什么值都不加入查询条件
        Example<Questions> ex = Example.of(model,matcher); //动态查询
        return dao.findAll(ex,pageable);
    }
    /**
     * 保存
     *
     * @param model
     */
    @Override
    public Questions save(Questions model) {
        return dao.save(model);
    }

    @Override
    public Questions getOne(Integer id) {
        return dao.getOne(id);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
