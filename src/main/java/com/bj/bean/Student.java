package com.bj.bean;

import javax.persistence.*;

/**
 * Student：
 * 2020/3/28 8:35
 * by kzm
 */
@Entity
@Table(name = "student")
public class Student extends BaseBean{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //姓名
    @Column(name = "name")
    private String name;

    //学校 0 小学 1 初中 2 高中
    @Column(name = "school")
    private Integer school;
    //年级
    @Column(name = "grade")
    private Integer grade;

    //家长
    @Column(name = "parent")
    private String parent;
    //电话
    @Column(name = "phone")
    private String phone;

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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
