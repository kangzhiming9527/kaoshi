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

    //知识分类
//    @ManyToOne(targetEntity = Knowledge.class, fetch = FetchType.EAGER)
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
    private Integer rightCount;
    //错误次数
    @Column(name = "wrong_count")
    private Integer wrongCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    //知识点 分类名称
    public String getKnowledgeStr() {
        return knowledge.getType2();
    }

    public void setWrong3(String wrong3) {
        this.wrong3 = wrong3;
    }

    public Integer getRightCount() {
        return rightCount;
    }

    public void setRightCount(Integer rightCount) {
        this.rightCount = rightCount;
    }

    public Integer getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(Integer wrongCount) {
        this.wrongCount = wrongCount;
    }
}
