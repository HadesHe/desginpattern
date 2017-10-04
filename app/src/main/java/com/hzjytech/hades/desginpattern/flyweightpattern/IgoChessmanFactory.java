package com.hzjytech.hades.desginpattern.flyweightpattern;

import java.util.Hashtable;

/**
 * Created by zhanghehe on 2017/10/3.
 */

public class IgoChessmanFactory {

    private static IgoChessmanFactory instance=new IgoChessmanFactory();

    private static Hashtable ht;

    private IgoChessmanFactory(){
        ht=new Hashtable();
        IgoChessman black,white;
        black=new BlackIgoChessman();
        ht.put("b",black);
        white=new WhiteIgoChessman();
        ht.put("w",white);

    }

    public static IgoChessmanFactory getInstance(){
        return instance;
    }

    public IgoChessman getIgoChessman(String color){
        return (IgoChessman) ht.get(color);
    }
}
