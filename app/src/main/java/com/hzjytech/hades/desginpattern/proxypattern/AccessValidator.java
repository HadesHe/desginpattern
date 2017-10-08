package com.hzjytech.hades.desginpattern.proxypattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/7.
 */

class AccessValidator {
    public boolean validate(String userId){
        LogOut.println("check userid"+userId);
        if(userId.equals("123")){
            LogOut.println("Login success"+userId);
            return true;
        }else{
            LogOut.println("Login fail"+userId);
            return false;
        }
    }
}
