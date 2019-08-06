package io.hz.modules.mis.entity;

public class ExportEntity {
    private String title;
    private Double price;
    private Integer testnumber;
    private String testintroduce;
    private String createtime;
    private String cname;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
