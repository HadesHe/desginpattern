package com.hzjytech.hades.desginpattern.chainresponsibitlity.example;

/**
 * Created by zhanghehe on 2017/10/15.
 */

public class Request {

    private String name;
    private int days;

    public Request(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
