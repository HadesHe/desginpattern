package com.hzjytech.hades.desginpattern.chainresponsibitlity;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/14.
 */

class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<500000){
            LogOut.println("President:"+this.name+",request"+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }
    }
}
