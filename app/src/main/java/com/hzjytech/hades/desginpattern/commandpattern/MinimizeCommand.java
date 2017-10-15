package com.hzjytech.hades.desginpattern.commandpattern;

/**
 * Created by zhanghehe on 2017/10/15.
 */

public class MinimizeCommand extends Command {
    private WindowHandler whObj;

    public MinimizeCommand(){
        whObj=new WindowHandler();
    }

    @Override
    public void execute() {
        whObj.minimize();
    }
}
