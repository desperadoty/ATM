package com.po;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/9.
 * 转账信息实体类
 */
public class Transfer {
    private int index; //转账交易序号
    private String transferout; //转出账户
    private String transferin; //转入账户
    private double amount; //转账金额
    private String transferdate; //转账日期

    public Transfer() {

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTransferout() {
        return transferout;
    }

    public void setTransferout(String transferout) {
        this.transferout = transferout;
    }

    public String getTransferin() {
        return transferin;
    }

    public void setTransferin(String transferin) {
        this.transferin = transferin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransferdate() {
        return transferdate;
    }

    public void setTransferdate(String transferdate) {
        this.transferdate = transferdate;
    }
}
