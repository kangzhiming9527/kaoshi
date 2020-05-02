package com.bj.dao;

import com.bj.bean.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * Knowledge：
 * 2020/2/23 20:30
 * by kzm
 */
public interface KnowledgeDao extends JpaRepository<Knowledge, Integer> {
    @Query(value = "SELECT type1 FROM knowledge GROUP BY type1", nativeQuery = true)
    List<String> type1List();

    @Query(value = "SELECT id,type2 FROM knowledge WHERE type1 = ?1", nativeQuery = true)
    List<Map<String,Object>> type2List(String type1);
}
