package com.hzjytech.hades.desginpattern.statepattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

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
        this.state=new NormalState(state);
        LogOut.println(this.owner+" start Account"+ balance);
        LogOut.println("------------------------------");
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setState(AccountState state){
        this.state=state;
    }

    public void deposit(double amount){
        LogOut.println(this.owner+" deposit"+amount);
        state.deposit(amount);
        LogOut.println("Now balance is "+this.balance);
        LogOut.println("Now state is "+this.state.getClass().getName());
        LogOut.println("------------------------------------");
    }

    public void withdraw(double amount){
        LogOut.println(this.owner+" withdraw"+amount);
        state.withdraw(amount);
        LogOut.println("Now balance is"+this.balance);
        LogOut.println("now state is "+this.state.getClass().getName());
        LogOut.println("-------------------------------------");

    }

    public void computeInterest(){
        state.computeInterest();
    }
}


abstract class AccountState{
    protected Account acc;
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public abstract void computeInterest();
    public abstract void stateCheck();
}

class NormalState extends AccountState{

    public NormalState(AccountState account) {
        this.acc=account.acc;
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();

    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance()-amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        LogOut.println("Normal State, No interest");

    }

    @Override
    public void stateCheck() {
        if(acc.getBalance()>-2000&&acc.getBalance()<=0){
            acc.setState(new OverdraftState(this));
        }else if(acc.getBalance()==-2000){
            acc.setState(new RestrictedState(this));
        }else if(acc.getBalance()<-2000){
            LogOut.println("Limit");
        }

    }
}

class OverdraftState extends AccountState{

    public OverdraftState(AccountState a){
        this.acc=a.acc;
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();

    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance()-amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        LogOut.println("compute Interest");

    }

    @Override
    public void stateCheck() {
        if(acc.getBalance()>0){
            acc.setState(new NormalState(this));
        }else if(acc.getBalance()==-2000){
            acc.setState(new RestrictedState(this));
        }else if(acc.getBalance()<-2000){
            LogOut.println("Limit");
        }

    }
}

class RestrictedState extends AccountState{

    public RestrictedState(AccountState state){
        this.acc=state.acc;
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        LogOut.println("Limit");

    }

    @Override
    public void computeInterest() {
        LogOut.println("computeInterest");

    }

    @Override
    public void stateCheck() {
        if(acc.getBalance()>0){
            acc.setState(new NormalState(this));
        }else if(acc.getBalance()>-2000){
            acc.setState(new OverdraftState(this));
        }

    }
}