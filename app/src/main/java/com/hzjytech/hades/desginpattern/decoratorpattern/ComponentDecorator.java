package com.hzjytech.hades.desginpattern.decoratorpattern;

/**
 * Created by Hades on 2017/9/26.
 */

public class ComponentDecorator extends Component {

    private Component component;

    public ComponentDecorator(Component component){
        this.component=component;
    }
    @Override
    void display() {
        component.display();
    }
}
