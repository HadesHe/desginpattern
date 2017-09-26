package com.hzjytech.hades.desginpattern.decoratorpattern;

/**
 * Created by Hades on 2017/9/26.
 */

public class ScrollBarDecorator extends ComponentDecorator {


    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    void display() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        System.out.println("ScrollBarDecorator");
    }
}
