package com.hzjytech.hades.desginpattern.compositepattern.exmaple;

/**
 * Created by Hades on 2017/9/25.
 */

public class ButtonView extends AbstractView {

    private final String name;

    public ButtonView(String name){
        this.name=name;
    }
    @Override
    public void addView(AbstractView abstractView) {
        System.out.println("ButtonView cannot addView" );

    }

    @Override
    public void removeView(AbstractView abstractView) {
        System.out.println("ButtonView cannot removeView" );

    }

    @Override
    public void show() {
        System.out.println("ButtonView show"+name );

    }

    @Override
    public void setText(String text) {
        System.out.println("ButtonView setText "+text );

    }
}
