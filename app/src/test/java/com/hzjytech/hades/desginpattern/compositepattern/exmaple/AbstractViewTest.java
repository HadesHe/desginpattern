package com.hzjytech.hades.desginpattern.compositepattern.exmaple;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/9/25.
 */
public class AbstractViewTest {


    @Test
    public void testCompositePattern() throws Exception {
        AbstractView view1,view2,view3,view4,Comp0,Comp1,Comp2;


        view1=new ButtonView("Username");
        view2=new ButtonView("Password");
        view3=new TextView("yonghuaming");
        view4=new TextView("mima");

        Comp0=new MidControlView();
        Comp1=new MidControlView();
        Comp2=new WindowView();
        Comp1.addView(view1);
        Comp2.addView(view2);
        Comp2.addView(view3);
        Comp0.addView(view4);
        Comp0.addView(Comp1);
        Comp0.addView(Comp2);
        Comp0.show();
    }
}