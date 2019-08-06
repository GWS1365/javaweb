package io.hz.modules.mis.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.sql.Date;

@TableName("mis_reality_result")
public class MisReality_resultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private String testtime;

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
    private String presult;

    @TableField(exist = false)
    private String pdetails;

    @TableField(exist = false)
    private String timgsrc;

    public String getTimgsrc() {
        return timgsrc;
    }

    public void setTimgsrc(String timgsrc) {
        this.timgsrc = timgsrc;
    }

    public String getPdetails() {
        return pdetails;
    }

    public void setPdetails(String pdetails) {
        this.pdetails = pdetails;
    }

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

    public String getPresult() {
        return presult;
    }

    public void setPresult(String presult) {
        this.presult = presult;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
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
