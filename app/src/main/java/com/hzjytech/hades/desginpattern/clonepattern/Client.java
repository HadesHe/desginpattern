package com.hzjytech.hades.desginpattern.clonepattern;

/**
 * Created by Hades on 2017/9/12.
 */

public class Client {

    public void testClonePattern(){
        WeeklyLog weeklyLog=new WeeklyLog();
        weeklyLog.setName("大鱼");
        weeklyLog.setDate("912");
        weeklyLog.setContent("大鱼");

        System.out.printf(weeklyLog.toString());

        WeeklyLog weeklyLog1=weeklyLog.clone();
        System.out.printf(weeklyLog1.toString());

    }
}
