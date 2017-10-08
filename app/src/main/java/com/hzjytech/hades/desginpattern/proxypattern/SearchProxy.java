package com.hzjytech.hades.desginpattern.proxypattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/7.
 */

public class SearchProxy implements Search {

    private RealSearch realSearch=new RealSearch();
    private AccessValidator accessValidator;
    @Override
    public String doSearch(String userId, String keyword) {
        if(validate(userId)){
            String result=realSearch.doSearch(userId,keyword);
            LogOut.println(result);
            return result;

        }
        return null;
    }

    private boolean validate(String userId) {
        accessValidator=new AccessValidator();
        return accessValidator.validate(userId);
    }
}
