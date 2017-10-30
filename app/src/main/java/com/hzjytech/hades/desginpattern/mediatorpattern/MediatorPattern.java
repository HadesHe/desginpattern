package com.hzjytech.hades.desginpattern.mediatorpattern;

import android.util.Log;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/29.
 */
abstract class Mediator{
    public abstract void componentChanged(Component component);
}



abstract class Component{
    protected Mediator mediator;
    public void setMediator(Mediator mediator){
        this.mediator=mediator;
    }

    public void change(){
        mediator.componentChanged(this);
    }
}

class Button extends Component{
    public void update(){

    }
}

class List extends Component{
    public void update(){
        LogOut.println("list update");
    }

    public void select(){
        LogOut.println("list select");
    }
}

class ComboBox extends Component{
    public void update(){
        LogOut.println("ComboBox update");
    }

    public void select(){
        LogOut.println("ComboBox select");
    }

}

class TextBox extends Component{
    public void update(){
        LogOut.println("TextBox update clear ComboBox");
    }

    public void setText(){
        LogOut.println("TextBox setText");
    }

}

class Label extends Component{
    public void update(){
        LogOut.println("Label change");
    }
}

class SubMediatorPattern extends MediatorPattern{
    public Label label;

    public void componentChange(Component component){

        if(component==addButton){
            LogOut.println("add Button");
            list.update();
            cb.update();
            userNameTextBox.update();
            label.update();

        }else if(component==list){
            LogOut.println("select list");
            cb.select();
            userNameTextBox.setText();


        }else if(component==cb){
            LogOut.println("CombBox");
            cb.select();
            userNameTextBox.setText();

        }

    }
}


public class MediatorPattern extends Mediator{

    public Button addButton;
    public List list;
    public TextBox userNameTextBox;
    public ComboBox cb;


    @Override
    public void componentChanged(Component component) {

        if(component==addButton){
            LogOut.println("add Button");
            list.update();
            cb.update();
            userNameTextBox.update();

        }else if(component==list){
            LogOut.println("select list");
            cb.select();
            userNameTextBox.setText();

        }else if(component==cb){
            LogOut.println("CombBox");
            cb.select();
            userNameTextBox.setText();

        }

    }
}
