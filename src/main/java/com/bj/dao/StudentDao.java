package com.bj.dao;

import com.bj.bean.Student;
import com.bj.bean.TreeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * Knowledge：
 * 2020/2/23 20:30
 * by kzm
 */
public interface StudentDao extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT grade AS VALUE, CASE grade WHEN 1 THEN '一年级' WHEN 2 THEN '二年级' WHEN 3 THEN '三年级' WHEN 4 THEN '四年级' WHEN 5 THEN '五年级' WHEN 6 THEN '六年级' ELSE '其他' END AS NAME,0 AS pid FROM student GROUP BY grade UNION SELECT id AS VALUE, NAME, grade AS pid FROM student ", nativeQuery = true)
    List<Map<String,Object>> studentTree();
}
