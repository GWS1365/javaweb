package io.hz.modules.mis.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("mis_prestore_result")
public class MisPrestore_resultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private String result;

    private String details;

    private Integer maxscore;

    private Integer minscore;

    private Integer tid;

    @TableField(exist = false)
    private String tname;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(Integer maxscore) {
        this.maxscore = maxscore;
    }

    public Integer getMinscore() {
        return minscore;
    }

    public void setMinscore(Integer minscore) {
        this.minscore = minscore;
    }
}
