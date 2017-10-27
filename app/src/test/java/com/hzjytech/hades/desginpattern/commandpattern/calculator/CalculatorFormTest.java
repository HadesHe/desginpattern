package com.hzjytech.hades.desginpattern.commandpattern.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/10/22.
 */
public class CalculatorFormTest {

    @Test
    public void testCalculatorForm() throws Exception {
        CalculatorForm form=new CalculatorForm();
        AbstractCommand command;
        command=new ConcreteCommand();

        form.setCommand(command);

        form.compute(10);
        form.compute(5);
        form.compute(10);
        form.undo();
    }
}