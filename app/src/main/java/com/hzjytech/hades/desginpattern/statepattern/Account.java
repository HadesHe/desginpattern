package com.hzjytech.hades.desginpattern.statepattern;

/**
 * Created by Hades on 2017/11/15.
 */

public class Account {
    private AccountState state;
    private String owner;
    private double balance=0;

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.state=new NormalState(this);
    }
}


abstract class AccountState{
    protected Account acc;
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public abstract void computeInterest();
    public abstract void stateCheck();
}