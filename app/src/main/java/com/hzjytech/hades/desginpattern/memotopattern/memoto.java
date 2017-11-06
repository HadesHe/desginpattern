package com.hzjytech.hades.desginpattern.memotopattern;

import java.util.ArrayList;

/**
 * Created by zhanghehe on 2017/11/5.
 */

public class memoto {
    private ArrayList mementoList=new ArrayList();

    public ChessmanMemento getMemento(int i){
        return (ChessmanMemento) mementoList.get(i);
    }


    public void setMemento(ChessmanMemento memento) {
        mementoList.add(memento);
    }
}


class Chessman{
    private String lable;

    private int x;
    private int y;
    public Chessman(String lable,int x,int y){
        this.lable=lable;
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ChessmanMemento save(){
        return new ChessmanMemento(this.lable,this.x,this.y);

    }

    public void restore(ChessmanMemento memento){
        this.lable=memento.getLabel();
        this.x=memento.getX();
        this.y=memento.getY();
    }

}

class ChessmanMemento{
    private String label;
    private int x;
    private int y;


    public ChessmanMemento(String lable, int x, int y) {
        this.label=lable;
        this.x=x;
        this.y=y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
