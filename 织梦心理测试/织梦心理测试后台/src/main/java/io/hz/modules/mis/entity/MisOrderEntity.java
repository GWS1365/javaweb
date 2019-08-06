package io.hz.modules.mis.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("mis_order")
public class MisOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private String orderid;

    private Date createtime;

    private Integer status;

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

    //    private MisUserEntity misUserEntity;
//
//    private  MisTestEntity misTestEntity;
//
//    public MisUserEntity getMisUserEntity() {
//        return misUserEntity;
//    }
//
//    public void setMisUserEntity(MisUserEntity misUserEntity) {
//        this.misUserEntity = misUserEntity;
//    }
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

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
