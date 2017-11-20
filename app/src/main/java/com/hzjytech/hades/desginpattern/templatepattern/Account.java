package com.hzjytech.hades.desginpattern.templatepattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by Hades on 2017/11/20.
 */

abstract class Account {

    public boolean validate(String account,String password){
        LogOut.println("account:"+account);
        LogOut.println("password:"+password);

        if(account.equals("laowang")&&password.equals("123456")){
            return true;
        }else{
            return false;
        }
    }

    public abstract void calculateInterest();

    public void display(){
        LogOut.println("display");
    }

    public void handle(String account,String password){
        if(!validate(account,password)){
            LogOut.println("account or password error");
            return;
        }
        calculateInterest();
        display();
    }
}

class CurrentAccount extends Account{

    @Override
    public void calculateInterest() {
        LogOut.println("calculateInterest by year");

    }
}
