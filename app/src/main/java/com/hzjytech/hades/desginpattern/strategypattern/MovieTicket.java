package com.hzjytech.hades.desginpattern.strategypattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by Hades on 2017/11/20.
 */

class MovieTicket {
    private double price;
    private Discount discount;

    public double getPrice() {
        return discount.calculate(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}

interface Discount{
    public double calculate(double price);
}

class StudentDiscount implements Discount{

    @Override
    public double calculate(double price) {
        LogOut.println("Student");
        return price*0.8;
    }
}

class ChildrenDiscount implements Discount{

    @Override
    public double calculate(double price) {
        LogOut.println("Children");
        return price-10;
    }
}

class VIPDiscount implements Discount{

    @Override
    public double calculate(double price) {
        LogOut.println("VIP");
        LogOut.println("add Reward point");
        return price*0.5;
    }
}