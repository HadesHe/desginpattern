package com.hzjytech.hades.desginpattern.chainresponsibitlity;

/**
 * Created by zhanghehe on 2017/10/14.
 */

abstract class Approver {
    protected Approver successor;
    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    public abstract void processRequest(PurchaseRequest request);
}
