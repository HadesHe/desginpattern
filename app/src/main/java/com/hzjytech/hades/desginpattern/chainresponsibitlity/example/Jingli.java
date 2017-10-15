package com.hzjytech.hades.desginpattern.chainresponsibitlity.example;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/15.
 */

public class Jingli extends VacateApprove {

    public Jingli(String name) {
        super(name);
    }

    @Override
    public void handleVacateApprove(Request request) {

        if(request.getDays()<10){
            LogOut.println("经理"+name+"批准了"+request.getName()+request.getDays()+"天的请假");
        }else {
            vacateApprove.handleVacateApprove(request);
        }
    }
}

