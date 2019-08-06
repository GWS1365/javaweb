package io.hz.modules.mis.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

@TableName("mis_comment")
public class MisCommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private String createtime;

    private String content;

    private Integer testunderstand;

    private Integer testexact;

    private Integer testpractical;

    private Integer uid;

    private Integer tid;

    @TableField(exist = false)
    private String uname;

    @TableField(exist = false)
    private String tname;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTestunderstand() {
        return testunderstand;
    }

    public void setTestunderstand(Integer testunderstand) {
        this.testunderstand = testunderstand;
    }

    public Integer getTestexact() {
        return testexact;
    }

    public void setTestexact(Integer testexact) {
        this.testexact = testexact;
    }

    public Integer getTestpractical() {
        return testpractical;
    }

    public void setTestpractical(Integer testpractical) {
        this.testpractical = testpractical;
    }
}
