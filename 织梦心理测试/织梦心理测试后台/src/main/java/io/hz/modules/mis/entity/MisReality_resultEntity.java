package io.hz.modules.mis.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("mis_reality_result")
public class MisReality_resultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private Date testtime;

    private Integer status;

    private Integer scoresum;

    private Integer uid;

    private Integer tid;

    private Integer pid;

    @TableField(exist = false)
    private String uname;

    @TableField(exist = false)
    private String tname;

    @TableField(exist = false)
    private String pname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    //    private MisUserEntity misUserEntity;
//
//    private MisTestEntity misTestEntity;
//
//    private  MisPrestore_resultEntity misPrestore_resultEntity;
//
//    public MisTestEntity getMisTestEntity() {
//        return misTestEntity;
//    }
//
//    public void setMisTestEntity(MisTestEntity misTestEntity) {
//        this.misTestEntity = misTestEntity;
//    }
//
//    public MisPrestore_resultEntity getMisPrestore_resultEntity() {
//        return misPrestore_resultEntity;
//    }
//
//    public void setMisPrestore_resultEntity(MisPrestore_resultEntity misPrestore_resultEntity) {
//        this.misPrestore_resultEntity = misPrestore_resultEntity;
//    }
//
//    public MisUserEntity getMisUserEntity() {
//        return misUserEntity;
//    }
//
//    public void setMisUserEntity(MisUserEntity misUserEntity) {
//        this.misUserEntity = misUserEntity;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getScoresum() {
        return scoresum;
    }

    public void setScoresum(Integer scoresum) {
        this.scoresum = scoresum;
    }
}
