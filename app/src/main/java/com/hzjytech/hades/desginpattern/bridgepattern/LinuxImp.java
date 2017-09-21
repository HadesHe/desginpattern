package com.hzjytech.hades.desginpattern.bridgepattern;

/**
 * Created by Hades on 2017/9/21.
 */

public class LinuxImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("Linux doPaint");
    }
}
