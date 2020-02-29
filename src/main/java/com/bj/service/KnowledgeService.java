package com.bj.service;

import com.bj.bean.Knowledge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * KnowledgeService：
 * 2020/2/23 20:35
 * by kzm
 */
public interface KnowledgeService {
    /**
     * 列表查询
     *
     *
     * @param model
     * @param pageable
     * @return
     */
    Page<Knowledge> list(Knowledge model, Pageable pageable);

    /**
     * 保存
     *
     * @param model
     */
    Knowledge save(Knowledge model);

    Knowledge getOne(Integer id);

    void deleteById(Integer id);
}
