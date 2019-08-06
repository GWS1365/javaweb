package io.hz.modules.mis.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("mis_test")
public class MisTestEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private String title;

    private String imgsrc;

    private Double price;

    private Integer testnumber;

    private String testintroduce;

    private String createtime;

    private Integer cid;

    @TableField(exist = false)
    private Integer nid;

    /**
     * 关联另一张表
     */
    @TableField(exist = false)
    private String cname;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTestnumber() {
        return testnumber;
    }

    public void setTestnumber(Integer testnumber) {
        this.testnumber = testnumber;
    }

    public String getTestintroduce() {
        return testintroduce;
    }

    public void setTestintroduce(String testintroduce) {
        this.testintroduce = testintroduce;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
