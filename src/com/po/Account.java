package com.po;

/**
 * Created by Administrator on 2017/3/2.
 * 账户基本信息实体类
 */
public class Account {
    private String id; // 银行卡号
    private String username; //用户名
    private String password; // 密码
    private String gender; //性别
    private double balance; // 余额


    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
