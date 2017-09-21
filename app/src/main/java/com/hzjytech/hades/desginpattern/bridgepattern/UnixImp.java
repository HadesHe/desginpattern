package com.hzjytech.hades.desginpattern.bridgepattern;

/**
 * Created by Hades on 2017/9/21.
 */

public class UnixImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("Unix doPaint");
    }
}
