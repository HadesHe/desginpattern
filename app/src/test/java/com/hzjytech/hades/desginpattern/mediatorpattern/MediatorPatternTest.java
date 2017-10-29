package com.hzjytech.hades.desginpattern.mediatorpattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/10/29.
 */
public class MediatorPatternTest {

    @Test
    public void testMediatorPattern() throws Exception {
        MediatorPattern mediatorPattern=new MediatorPattern();

        Button addBt=new Button();
        List list=new List();
        ComboBox cb=new ComboBox();
        TextBox userTb=new TextBox();

        addBt.setMediator(mediatorPattern);
        list.setMediator(mediatorPattern);
        cb.setMediator(mediatorPattern);
        userTb.setMediator(mediatorPattern);

        mediatorPattern.addButton=addBt;
        mediatorPattern.list=list;
        mediatorPattern.cb=cb;
        mediatorPattern.userNameTextBox=userTb;

        addBt.change();
        LogOut.println("-------------");
        list.change();

    }
}