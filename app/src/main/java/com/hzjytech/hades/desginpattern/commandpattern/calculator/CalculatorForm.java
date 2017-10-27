package com.hzjytech.hades.desginpattern.commandpattern.calculator;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/21.
 */

public class CalculatorForm {

    private AbstractCommand command;

    public void setCommand(AbstractCommand command){
        this.command=command;
    }

    public void compute(int value){
        int i=command.execute(value);
        LogOut.println("compute result: "+i);
    }

    public void undo(){
        int i=command.undo();
        LogOut.println("undo result:"+i);
    }
}
