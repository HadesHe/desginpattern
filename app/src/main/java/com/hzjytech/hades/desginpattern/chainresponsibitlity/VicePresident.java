package com.hzjytech.hades.desginpattern.chainresponsibitlity;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/14.
 */

class VicePresident extends Approver {

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<100000){
            LogOut.println("VicePresident:"+this.name+",request"+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }
    }
}
