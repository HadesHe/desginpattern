package com.hzjytech.hades.desginpattern.commandpattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/15.
 */

class FunctionButton {
    private String name;
    private Command command;

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onClick(){
        LogOut.println("onClick");
        command.execute();
    }
}
