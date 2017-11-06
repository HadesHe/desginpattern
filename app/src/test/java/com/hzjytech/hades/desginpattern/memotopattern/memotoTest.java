package com.hzjytech.hades.desginpattern.memotopattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/11/5.
 */
public class memotoTest {

    memoto memoto1=new memoto();
    private int index=-1;

    @Test
    public void testMemotoPattern() throws Exception {

        Chessman chessman=new Chessman("Horse",1,1);
        play(chessman);
        chessman.setX(4);
        play(chessman);
        chessman.setY(5);
        play(chessman);
        undo(chessman,index);
        undo(chessman,index);
        redo(chessman,index);
        redo(chessman,index);

    }

    private void undo(Chessman chessman, int i) {
        LogOut.println("-------undo-------");
        index--;
        chessman.restore(memoto1.getMemento(i-1));
        LogOut.println("chess"+chessman.getLable()+"("+chessman.getX()
                +","+chessman.getY()+")");
    }

    private void redo(Chessman chessman,int i){
        LogOut.println("---------redo--------");
        index++;
        chessman.restore(memoto1.getMemento(i+1));
        LogOut.println("chess"+chessman.getLable()+"("+chessman.getX()
                +","+chessman.getY()+")");
    }

    private void play(Chessman chessman) {
        memoto1.setMemento(chessman.save());
        index++;
        LogOut.println("chess"+chessman.getLable()+"("+chessman.getX()
        +","+chessman.getY()+")");

    }

}