package io.hz.modules.mis.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("mis_note")
public class MisNoteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private Integer footmark;

    private Integer collect;

    private Integer like;

    private Integer tid;

    private Integer uid;

    @TableField(exist = false)
    private String tname;

    @TableField(exist = false)
    private String uname;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFootmark() {
        return footmark;
    }

    public void setFootmark(Integer footmark) {
        this.footmark = footmark;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }
}
