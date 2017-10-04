package com.hzjytech.hades.desginpattern.flyweightpattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/10/3.
 */
public class IgoChessmanFactoryTest {

    @Test
    public void testIgoChessmanFactory() throws Exception{
        IgoChessman black1,black2,black3,white1,white2;
        IgoChessmanFactory factory;

        factory=IgoChessmanFactory.getInstance();

        black1=factory.getIgoChessman("b");
        black2=factory.getIgoChessman("b");
        black3=factory.getIgoChessman("b");

        LogOut.println("black1 == black2"+(black1==black2));
        LogOut.println("black2 == black3"+(black2==black3));

        white1=factory.getIgoChessman("w");
        white2=factory.getIgoChessman("w");

        LogOut.println("white1==white2"+(white1==white2));

        black1.display(new Coordinates(1,2));
        black2.display(new Coordinates(3,4));
        black3.display(new Coordinates(1,3));
        white1.display(new Coordinates(2,5));
        white2.display(new Coordinates(2,4));
    }

    @Test
    public void testString() throws Exception{
        String str1="abcd";
        String str2="abcd";
        String str3="ab"+"cd";
        String str4="ab";
        str4+="cd";

        LogOut.println("str1==str2:"+(str1==str2));
        LogOut.println("str1==str3:"+(str1==str3));
        LogOut.println("str1==str4:"+(str1==str4));

        str2+="e";
        LogOut.println("str1==str2"+(str1==str2));

    }

}