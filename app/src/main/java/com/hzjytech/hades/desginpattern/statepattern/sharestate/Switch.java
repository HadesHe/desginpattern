package com.hzjytech.hades.desginpattern.statepattern.sharestate;

/**
 * Created by Hades on 2017/11/17.
 */

public class Switch {
    private static State state,onState,offState;

    private String name;

    public Switch(String name){
        this.name=name;
        onState=new OnState();
        offState=new OffState();
        this.state=onState;
    }

    public void setState
}


abstract class State{
    public abstract void on(Switch s);
    public abstract void off(Switch s);

}