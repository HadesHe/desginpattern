package com.hzjytech.hades.desginpattern.compositepattern.exmaple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hades on 2017/9/25.
 */

public class WindowView extends AbstractView {

    private List<AbstractView>  lstView=new ArrayList<>();
    @Override
    public void addView(AbstractView abstractView) {
        lstView.add(abstractView);

    }

    @Override
    public void removeView(AbstractView abstractView) {
        lstView.remove(abstractView);

    }

    @Override
    public void show() {
        for (AbstractView abstractView : lstView) {
            System.out.println("WIndow");
            abstractView.show();
        }

    }

    @Override
    public void setText(String text) {
        System.out.println("Window cannot setText " );

    }
}
