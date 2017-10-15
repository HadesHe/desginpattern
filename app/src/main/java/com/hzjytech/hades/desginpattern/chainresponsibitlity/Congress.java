package com.hzjytech.hades.desginpattern.chainresponsibitlity;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/14.
 */

class Congress extends Approver {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
            LogOut.println("Congress:"+this.name+",request"+request.getPurpose());
    }
}
