package com.bj.dao;

import com.bj.bean.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Knowledge：
 * 2020/2/23 20:30
 * by kzm
 */
public interface QuestionsDao extends JpaRepository<Questions, Integer> {
}
