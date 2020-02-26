package com.bj.service.impl;

import com.bj.bean.Questions;
import com.bj.dao.QuestionsDao;
import com.bj.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Page<Questions> list(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
