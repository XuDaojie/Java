package io.github.xudaojie.boot.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author xdj
 * @date 2018/9/14
 */
public class AccountEntity {
    private int id;
    private Timestamp createTime;
    private BigDecimal balance;
    // Getters and setters are omitted

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
