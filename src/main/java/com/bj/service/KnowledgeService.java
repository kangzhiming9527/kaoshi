package com.bj.service;

import com.bj.bean.Knowledge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

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
     * 获取知识点1清单
     * @return
     */
    List<String> type1List();
    /**
     * 获取知识点2清单
     * @return
     */
    List<Map<String,Object>> type2List(String type1);

    /**
     * 保存
     *
     * @param model
     */
    Knowledge save(Knowledge model);

    Knowledge getOne(Integer id);

    void deleteById(Integer id);
}
