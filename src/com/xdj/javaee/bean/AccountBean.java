package com.xdj.javaee.bean;

/**
 * Created by xdj on 2017/4/2.
 */
public class AccountBean {
    private long id;
    private String mUsername;
    private String mPassword;
//    private String mCountry;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

//    public String getCountry() {
//        return mCountry;
//    }

//    public void setCountry(String country) {
//        mCountry = country;
//    }
}
