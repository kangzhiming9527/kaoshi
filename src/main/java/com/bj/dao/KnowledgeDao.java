package com.bj.dao;

import com.bj.bean.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Knowledge：
 * 2020/2/23 20:30
 * by kzm
 */
public interface KnowledgeDao extends JpaRepository<Knowledge, Integer> {
}
