package com.bj.service.impl;

import com.bj.bean.Knowledge;
import com.bj.dao.KnowledgeDao;
import com.bj.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
     * @param pageable
     * @return
     */
    @Override
    public Page<Knowledge> list(Pageable pageable) {
        return dao.findAll(pageable);
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
}
