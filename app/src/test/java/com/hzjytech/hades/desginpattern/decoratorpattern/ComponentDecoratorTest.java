package com.hzjytech.hades.desginpattern.decoratorpattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/9/26.
 */
public class ComponentDecoratorTest {

    @Test
    public void testComponentDecorator() throws Exception {
        Component component,componentSB,componentBB;
        component=new Window();
        componentSB=new ScrollBarDecorator(component);
        componentBB=new BlackBorderDecorator(component);
        componentSB.display();
        componentBB.display();
    }

    @Test
    public void test() throws Exception {
        System.out.println("Beat small bro");
    }
}