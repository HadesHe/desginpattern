package com.hzjytech.hades.desginpattern.commandpattern.calculator;

/**
 * Created by zhanghehe on 2017/10/21.
 */

class Adder {

    private int num=0;

    public int add(int value){
        num+=value;
        return num;
    }
}
