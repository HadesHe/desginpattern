package com.hzjytech.hades.desginpattern.clonepattern;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Hades on 2017/9/12.
 */
public class ClientTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testClient(){


        WeeklyLog weeklyLog1=new WeeklyLog();
        weeklyLog1.setName("BigFish");
        weeklyLog1.setDate("912");
        weeklyLog1.setContent("Fish");
        System.out.println(weeklyLog1.getName()+","+weeklyLog1.getDate()+","+weeklyLog1.getContent());
        WeeklyLog weeklyLog2=weeklyLog1.clone();
        System.out.println(weeklyLog2.getName()+","+weeklyLog2.getDate()+","+weeklyLog2.getContent());
        System.out.println(weeklyLog1.getName()==weeklyLog2.getName());
        System.out.println(weeklyLog1.getDate()==weeklyLog2.getDate());
        System.out.println(weeklyLog1.getContent()==weeklyLog2.getContent());
        System.out.println(weeklyLog1.getClass()==weeklyLog2.getClass());
        System.out.println(weeklyLog1.toString()==weeklyLog2.toString());

    }
}