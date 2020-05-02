package com.bj.service.impl;

import com.bj.bean.Knowledge;
import com.bj.dao.KnowledgeDao;
import com.bj.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * KnowledgeServiceImpl：
 * 2020/2/23 20:40
 * by kzm
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    @Autowired
    private KnowledgeDao dao;

    /**
     * 列表查询
     *
     *
     * @param model
     * @param pageable
     * @return
     */
    @Override
    public Page<Knowledge> list(Knowledge model, Pageable pageable) {
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
//                .withMatcher("address" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
//                .withIgnorePaths("password");//忽略字段，即不管password是什么值都不加入查询条件
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("type1", ExampleMatcher.GenericPropertyMatchers.contains())//模糊查询匹配开头，即{username}%
                .withMatcher("type2" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withIgnorePaths("creationTime")
                .withIgnorePaths("updateTime")
                .withIgnorePaths("id");//忽略字段，即不管password是什么值都不加入查询条件
        Example<Knowledge> ex = Example.of(model,matcher); //动态查询
        return dao.findAll(ex,pageable);
    }

    /**
     * 获取知识点1清单
     *
     * @return
     */
    @Override
    public List<String> type1List() {
        return dao.type1List();
    }

    /**
     * 获取知识点2清单
     *
     * @param type1
     * @return
     */
    @Override
    public List<Map<String,Object>> type2List(String type1) {
        return dao.type2List(type1);
    }


    /**
     * 保存
     *
     * @param model
     */
    @Override
    public Knowledge save(Knowledge model) {
        return dao.save(model);
    }

    @Override
    public Knowledge getOne(Integer id) {
        return dao.getOne(id);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
