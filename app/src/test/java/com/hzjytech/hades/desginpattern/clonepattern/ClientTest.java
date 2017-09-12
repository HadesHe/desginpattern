package com.hzjytech.hades.desginpattern.clonepattern;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;


/**
 * Created by Hades on 2017/9/12.
 */
public class ClientTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testClient() throws IOException, ClassNotFoundException {


        WeeklyLog weeklyLog1=new WeeklyLog();
        Attachment  attachment = new Attachment();
        weeklyLog1.setAttachment(attachment);

        WeeklyLog weeklyLog2=weeklyLog1.deepclone();
        System.out.println(weeklyLog1.getAttachment()==weeklyLog2.getAttachment());
        System.out.println(weeklyLog1==weeklyLog2);

    }
}