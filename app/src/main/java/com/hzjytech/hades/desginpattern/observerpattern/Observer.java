package com.hzjytech.hades.desginpattern.observerpattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import java.util.ArrayList;

/**
 * Created by Hades on 2017/11/14.
 */

interface Observer {
    public String getName();

    public void setName(String name);

    public void help();

    public void beAttacked(AllyControlCenter acc);

}

abstract class AllyControlCenter{
    protected String allyName;
    protected ArrayList<Observer> player=new ArrayList<>();

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }


    public void join(Observer obs){
        LogOut.println(obs.getName()+"join"+allyName);
        player.add(obs);
    }

    public void quit(Observer obs){
        LogOut.println(obs.getName()+"quit"+allyName);
        player.remove(obs);
    }

    public abstract void notifyObserver(String name);
}

class Player implements Observer{

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void help() {
        LogOut.println("Hold on"+this.name+" help you");
    }

    @Override
    public void beAttacked(AllyControlCenter acc) {
        LogOut.println(this.name+" acc");
        acc.notifyObserver(name);
    }
}

class ConcreteAllyControlCenter extends AllyControlCenter{

    public ConcreteAllyControlCenter(String allyName){

    }

    @Override
    public void notifyObserver(String name) {

    }
}