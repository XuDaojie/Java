package io.github.xudaojie.mybatis.bean;

import java.util.Date;

public class GoodsBean {
    private Long id;
    private Date gmtCreate;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoodsBean{");
        sb.append("id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", goodsName='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
