package com.bj.bean;

import javax.persistence.*;

/**
 * Questions：问题实体类
 * 2020/2/23 18:12
 * by kzm
 */
@Entity
@Table(name = "questions")
public class Questions extends BaseBean {

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
    @ManyToOne(targetEntity = Knowledge.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "k_id", referencedColumnName = "id")
//     @JsonIgnore
    private Knowledge knowledge;
    //    private boolean isMore = false;
    //问题
    @Column(name = "content")
    private String content;
    //正确答案
    @Column(name = "right_answer")
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

    //正确次数
    @Column(name = "right_count")
    private int rightCount;
    //错误次数
    @Column(name = "wrong_count")
    private int wrongCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType1() {
        return type1;
    }

    public void setType1(int type1) {
        this.type1 = type1;
    }

    public int getType2() {
        return type2;
    }

    public void setType2(int type2) {
        this.type2 = type2;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getWrong1() {
        return wrong1;
    }

    public void setWrong1(String wrong1) {
        this.wrong1 = wrong1;
    }

    public String getWrong2() {
        return wrong2;
    }

    public void setWrong2(String wrong2) {
        this.wrong2 = wrong2;
    }

    public String getWrong3() {
        return wrong3;
    }

    public void setWrong3(String wrong3) {
        this.wrong3 = wrong3;
    }

    public int getRightCount() {
        return rightCount;
    }

    public void setRightCount(int rightCount) {
        this.rightCount = rightCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(int wrongCount) {
        this.wrongCount = wrongCount;
    }
}
