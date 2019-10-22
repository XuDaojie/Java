package io.github.xudaojie.boot.bean;

/**
 * @author xdj
 * @date 2018/9/14
 */
public class AccountDTO {
    private int id;
    private String name;
    private String createTime;
    private String balance;
    // Getters and setters are omitted

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}

