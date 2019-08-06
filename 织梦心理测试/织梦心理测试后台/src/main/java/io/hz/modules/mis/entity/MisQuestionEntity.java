package io.hz.modules.mis.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("mis_question")
public class MisQuestionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private String question;

    private String choicea;

    private String choiceb;

    private String choicec;

    private String choiced;

    private String choicee;

    private String choicef;

    private String choiceg;

    private String choiceh;

    private Integer tid;

    @TableField(exist = false)
    private String tname;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
    public Integer getTid() {
        return tid;
    }

    //    private MisTestEntity misTestEntity;
//
//    public MisTestEntity getMisTestEntity() {
//        return misTestEntity;
//    }
//
//    public void setMisTestEntity(MisTestEntity misTestEntity) {
//        this.misTestEntity = misTestEntity;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoicea() {
        return choicea;
    }

    public void setChoicea(String choicea) {
        this.choicea = choicea;
    }

    public String getChoiceb() {
        return choiceb;
    }

    public void setChoiceb(String choiceb) {
        this.choiceb = choiceb;
    }

    public String getChoicec() {
        return choicec;
    }

    public void setChoicec(String choicec) {
        this.choicec = choicec;
    }

    public String getChoiced() {
        return choiced;
    }

    public void setChoiced(String choiced) {
        this.choiced = choiced;
    }

    public String getChoicef() {
        return choicef;
    }

    public void setChoicef(String choicef) {
        this.choicef = choicef;
    }

    public String getChoiceg() {
        return choiceg;
    }

    public void setChoiceg(String choiceg) {
        this.choiceg = choiceg;
    }

    public String getChoiceh() {
        return choiceh;
    }

    public void setChoiceh(String choiceh) {
        this.choiceh = choiceh;
    }



    public String getChoicee() {
        return choicee;
    }

    public void setChoicee(String choicee) {
        this.choicee = choicee;
    }
}
