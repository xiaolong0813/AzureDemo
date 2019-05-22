package com.example.demo.Models;

public class Message {

    // Message 类不需要往数据库里存放，不用标识为@Entity。只需建立
    // 数据模型类即可
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}
