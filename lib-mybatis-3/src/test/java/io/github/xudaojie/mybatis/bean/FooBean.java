package io.github.xudaojie.mybatis.bean;

import java.io.Serializable;
import java.util.Date;


public class FooBean implements Serializable {
    private Long id;
    private String foo;

    private Date gmtCreate;
    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FooBean{");
        sb.append("id=").append(id);
        sb.append(", foo='").append(foo).append('\'');
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append('}');
        return sb.toString();
    }
}
