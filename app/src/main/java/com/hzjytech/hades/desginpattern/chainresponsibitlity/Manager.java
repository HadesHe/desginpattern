package com.hzjytech.hades.desginpattern.chainresponsibitlity;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/14.
 */

class Manager extends Approver {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<80000){
            LogOut.println("Manager:"+name+",request:"+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }

    }
}
