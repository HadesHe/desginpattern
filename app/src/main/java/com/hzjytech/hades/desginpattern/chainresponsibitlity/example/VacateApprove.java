package com.hzjytech.hades.desginpattern.chainresponsibitlity.example;

/**
 * Created by zhanghehe on 2017/10/15.
 */

abstract class VacateApprove {

    protected String name;

    public VacateApprove(String name) {
        this.name = name;
    }

    protected VacateApprove vacateApprove;

    public void setVacateApprove(VacateApprove vacateApprove) {
        this.vacateApprove = vacateApprove;
    }

    public abstract void handleVacateApprove(Request request);
}
