package com.hzjytech.hades.desginpattern.chainresponsibitlity;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/14.
 */

class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<50000){
            LogOut.println("Director:"+name+""+",request:"+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }
    }
}
