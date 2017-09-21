package com.hzjytech.hades.desginpattern.bridgepattern;

/**
 * Created by Hades on 2017/9/21.
 */

public abstract class Image {

    protected ImageImp imp;

    public void setImp(ImageImp imp) {
        this.imp = imp;
    }


    public abstract void parseFile(String fileName);
}
