package com.hzjytech.hades.desginpattern.decoratorpattern;

/**
 * Created by Hades on 2017/9/26.
 */

public class BlackBorderDecorator extends ComponentDecorator {


    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("set Black Border");
    }

}
