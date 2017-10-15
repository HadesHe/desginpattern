package com.hzjytech.hades.desginpattern.commandpattern;

import android.util.Log;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import java.util.ArrayList;

/**
 * Created by zhanghehe on 2017/10/15.
 */

public class FBSettingWindow {
    private String title;
    private ArrayList<FunctionButton> functionButtons=new ArrayList<>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addFunctionButton(FunctionButton functionButton){
        functionButtons.add(functionButton);
    }

    public void removeFunctionButton(FunctionButton functionButton){
        functionButtons.remove(functionButton);
    }

    public void display(){
        LogOut.println("Window:"+this.title);
        LogOut.println("Functions:");
        for (FunctionButton functionButton : functionButtons) {
            LogOut.println(functionButton.getName());
        }
        LogOut.println("---------------------");
    }


}



