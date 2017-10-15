package com.hzjytech.hades.desginpattern.commandpattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/10/15.
 */
public class CommandTest {

    @Test
    public void testCommand() throws Exception {
        FBSettingWindow fbSettingWindow=new FBSettingWindow("Function Setting Title");

        FunctionButton fb1,fb2;

        fb1=new FunctionButton("Fucntion 1");
        fb2=new FunctionButton("Fucntion 2");

        fbSettingWindow.addFunctionButton(fb1);
        fbSettingWindow.addFunctionButton(fb2);

        Command command1,command2;
        command1=new HelpCommand();
        command2=new MinimizeCommand();

        fbSettingWindow.display();

        fb1.setCommand(command1);
        fb2.setCommand(command2);

        fb1.onClick();
        fb2.onClick();

    }
}