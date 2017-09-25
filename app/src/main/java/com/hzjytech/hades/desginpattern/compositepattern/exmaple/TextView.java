package com.hzjytech.hades.desginpattern.compositepattern.exmaple;

/**
 * Created by Hades on 2017/9/25.
 */

public class TextView extends AbstractView {
    private final String name;

    public TextView(String name) {
        this.name=name;
    }

    @Override
    public void addView(AbstractView abstractView) {
        System.out.println("TextView cannot addView" );

    }

    @Override
    public void removeView(AbstractView abstractView) {
        System.out.println("TextView cannot removeView" );

    }

    @Override
    public void show() {
        System.out.println("TextView show"+name );

    }

    @Override
    public void setText(String text) {
        System.out.println("TextView setText "+text );

    }
}
