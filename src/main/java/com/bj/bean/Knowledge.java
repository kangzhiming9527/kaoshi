package com.bj.bean;

/**
 * knowledge：知识点实体类
 * 2020/2/23 18:20
 * by kzm
 */

import javax.persistence.*;

// 建库建表
//DROP TABLE category;
//
//CREATE TABLE category
//(
//    categoryid INT AUTO_INCREMENT PRIMARY KEY,
//    categoryname VARCHAR(10) NOT NULL
//);
//
//INSERT INTO category VALUES(NULL, '手机'), (NULL, '图书'), (NULL, '服装'), (NULL, '鞋帽');
//
//SELECT * FROM category;
@Entity
@Table(name = "knowledge")
public class Knowledge extends BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //科目    0 数学 1 语文 2 英语
    @Column(name = "type0")
    private int type0;

    //知识点分类1
    @Column(name = "type1")
    private String type1;

    //知识点分类1
    @Column(name = "type2")
    private String type2;

    public String getType0() {
        String str = "未知";
        switch (type0) {
            case 0:
                str = "数学";
                break;
            case 1:
                str = "语文";
                break;
            case 2:
                str = "英语";
                break;
            default:
                break;
        }
        return str;
    }

    public void setType0(int type0) {
        this.type0 = type0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }
}
