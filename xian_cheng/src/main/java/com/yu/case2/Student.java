package com.yu.case2;

import java.util.Date;

public class Student {

    private int id;
    private String name;
    private int age;
    private boolean flag;
    private Date birth;

    public Student(int id, String name, int age, boolean flag, Date birth) {
    this.id=id;
    this.name=name;
    this.age=age;
    this.flag=flag;
    this.birth=birth;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
