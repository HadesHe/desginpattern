package com.hzjytech.hades.desginpattern.iteratorpattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/10/23.
 */
public class AbstractObjectListTest {

    @Test
    public void testIterator() throws Exception {
        List products=new ArrayList();

        products.add("大鱼");
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("葵花宝典");
        products.add("四十二长进");

        AbstractObjectList list;
        AbstractIterator iterator;

        list=new ProductList(products);

        iterator=list.createIterator();

        LogOut.println("iterator");

        while (!iterator.isLast()){
            LogOut.println(iterator.getNextItem()+",");
            iterator.next();
        }

        LogOut.println("");
        LogOut.println("----------------------------");
        LogOut.println("Back iterator");

        while (!iterator.isFirst()){
            LogOut.println(iterator.getPreviousItem()+",");
            iterator.previous();
        }



    }
}