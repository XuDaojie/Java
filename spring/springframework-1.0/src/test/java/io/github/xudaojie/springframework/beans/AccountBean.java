package io.github.xudaojie.springframework.bean;

/**
 * 用户
 */
public class AccountBean {

    private String name;

    private String password;

    private GroupBean testGroupBean;

    public void init() {
        System.out.println(GroupBean.class.getName()+ ": init()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GroupBean getTestGroupBean() {
        return testGroupBean;
    }

    public void setTestGroupBean(GroupBean testGroupBean) {
        this.testGroupBean = testGroupBean;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TestBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
