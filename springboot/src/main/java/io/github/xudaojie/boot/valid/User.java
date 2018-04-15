package io.github.xudaojie.boot.valid;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

    private String username;
    private String password;

    /**
     *
     * @return
     */
    @NotEmpty(message = "不能为空")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
