package com.hzjytech.hades.desginpattern.commandpattern;

/**
 * Created by zhanghehe on 2017/10/21.
 */

class Invoker {

    private CommandQueue commandQueue;

    public Invoker(CommandQueue commandQueue){
        this.commandQueue=commandQueue;
    }

    public void setCommandQueue(CommandQueue commandQueue){
        this.commandQueue=commandQueue;
    }

    public void call(){
        commandQueue.execute();
    }

}
