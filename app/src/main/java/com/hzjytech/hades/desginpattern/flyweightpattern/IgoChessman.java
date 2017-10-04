package com.hzjytech.hades.desginpattern.flyweightpattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/3.
 */

public abstract class IgoChessman {

    public abstract String getColor();

    public void display(Coordinates coordinates){
        LogOut.println("Chess Color"+this.getColor()+"location("+coordinates.getX()+","+coordinates.getY()+")");
    }

}
