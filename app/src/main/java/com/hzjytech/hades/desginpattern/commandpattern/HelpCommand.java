package com.hzjytech.hades.desginpattern.commandpattern;

/**
 * Created by zhanghehe on 2017/10/15.
 */

public class HelpCommand extends Command {

    private final HelpHandler hhObj;

    public HelpCommand() {
        hhObj=new HelpHandler();
    }

    @Override
    public void execute() {
        hhObj.display();
    }
}
