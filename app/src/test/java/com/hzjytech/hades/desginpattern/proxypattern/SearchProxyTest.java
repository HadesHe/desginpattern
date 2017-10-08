package com.hzjytech.hades.desginpattern.proxypattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/10/7.
 */
public class SearchProxyTest {

    @Test
    public void testProxy() throws Exception{
        SearchProxy searchProxy=new SearchProxy();
        searchProxy.doSearch("123","222");
    }

}