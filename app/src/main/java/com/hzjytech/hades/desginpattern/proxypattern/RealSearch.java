package com.hzjytech.hades.desginpattern.proxypattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/7.
 */

class RealSearch implements Search {
    @Override
    public String doSearch(String userId, String keyword) {
        LogOut.println("userId:"+userId+",keyword:"+keyword);
        return "realContent";
    }
}
