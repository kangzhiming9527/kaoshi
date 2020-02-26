package com.bj.service;

import com.bj.bean.Questions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionsService {
    /**
     * 列表分页查询
     *
     * @param pageable
     * @return
     */
    Page<Questions> list(Pageable pageable);

}
