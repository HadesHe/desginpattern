package com.hzjytech.hades.desginpattern.chainresponsibitlity.example;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/15.
 */

public class Zhuren extends VacateApprove {

    public Zhuren(String name) {
        super(name);
    }

    @Override
    public void handleVacateApprove(Request request) {

        if(request.getDays()<3){
            LogOut.println("主任"+name+"批准了"+request.getName()+request.getDays()+"天的请假");
        }else {
            vacateApprove.handleVacateApprove(request);
        }
    }
}

