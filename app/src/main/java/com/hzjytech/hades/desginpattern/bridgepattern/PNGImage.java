package com.hzjytech.hades.desginpattern.bridgepattern;

/**
 * Created by Hades on 2017/9/21.
 */

public class PNGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        Matrix m=new Matrix();

        imp.doPaint(m);
        System.out.println(fileName+", PNG");
    }
}
