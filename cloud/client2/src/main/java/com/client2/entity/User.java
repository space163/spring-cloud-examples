package com.client2.entity;

/**
 * Created by space163 on 2019/4/9.
 */
public class User implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String account;
    private String phone;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
