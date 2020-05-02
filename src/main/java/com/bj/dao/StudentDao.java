package com.bj.dao;

import com.bj.bean.Student;
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
}
