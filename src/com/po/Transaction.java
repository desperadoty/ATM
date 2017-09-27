package com.po;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/9.
 * 交易信息实体类
 */
public class Transaction {
    private int index; //交易序号
    private String id; //交易账号
    private String transtype; //交易类型(存或取)
    private double amount; //交易数额
    private String transdate; //交易日期

    public Transaction() {

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate;
    }
}
