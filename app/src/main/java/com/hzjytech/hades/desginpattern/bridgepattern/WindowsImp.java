package com.hzjytech.hades.desginpattern.bridgepattern;

/**
 * Created by Hades on 2017/9/21.
 */

public class WindowsImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("Window doPaint");
    }
}
