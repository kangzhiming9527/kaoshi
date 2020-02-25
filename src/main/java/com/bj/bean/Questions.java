package com.bj.bean;

import javax.persistence.*;

/**
 * Questions：
 * 2020/2/23 18:12
 * by kzm
 */
@Entity
@Table(name="questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    //年级
    @Column(name = "type1")
    private int type1 = 0;
    //学期    0上学期 1 下学期
    @Column(name = "type2")
    private int type2 = 0;
    //知识分类
    @ManyToOne(targetEntity=Knowledge.class,fetch=FetchType.LAZY)
     @JoinColumn(name="k_id",referencedColumnName="id")
//     @JsonIgnore
    private Knowledge knowledge;
//    private boolean isMore = false;
    //问题
    @Column(name = "content")
    private String content;
    //正确答案
    @Column(name = "right")
    private String right;
    //错误答案1
    @Column(name = "wrong1")
    private String wrong1;
    //错误答案2
    @Column(name = "wrong2")
    private String wrong2;
    //错误答案3
    @Column(name = "wrong3")
    private String wrong3;

}
