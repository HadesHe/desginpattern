package com.hzjytech.hades.desginpattern.compositepattern.exmaple;

/**
 * Created by Hades on 2017/9/25.
 */

public abstract class AbstractView {

    public abstract void addView(AbstractView abstractView);

    public abstract void removeView(AbstractView abstractView);

    public abstract void show();

    public abstract void setText(String text);


}
