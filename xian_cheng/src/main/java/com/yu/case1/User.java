package com.yu.case1;

import java.sql.Timestamp;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className User
 * @description：
 * @date 2017/11/26 10:48
 */
public class User {
    private int id;
    private String name;
    private Timestamp createdTime;
    private Timestamp updatedTime;

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

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }
}
