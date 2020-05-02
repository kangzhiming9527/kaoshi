package com.bj.bean;

import javax.persistence.*;

/**
 * Teacher：老师实体类
 * 2020/3/28 8:35
 * by kzm
 */
@Entity
@Table(name = "teacher")
public class Teacher extends BaseBean{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //姓名
    @Column(name = "name")
    private String name;

    //科目    0 数学 1 语文 2 英语
    @Column(name = "type0")
    private Integer type0;

    //学校 0 小学 1 初中 2 高中
    @Column(name = "school")
    private Integer school;
    //年级
    @Column(name = "grade")
    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType0() {
        return type0;
    }

    public void setType0(Integer type0) {
        this.type0 = type0;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
