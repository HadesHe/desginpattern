package com.hzjytech.hades.desginpattern.chainresponsibitlity.example;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/15.
 */

public class ZongJingli extends VacateApprove {

    public ZongJingli(String name) {
        super(name);
    }

    @Override
    public void handleVacateApprove(Request request) {

        if(request.getDays()<30){
            LogOut.println("总经理"+name+"批准了"+request.getName()+request.getDays()+"天的请假");
        }else {
            LogOut.println("总经理"+name+"批准了"+request.getName()+"离职申请");
        }
    }
}

