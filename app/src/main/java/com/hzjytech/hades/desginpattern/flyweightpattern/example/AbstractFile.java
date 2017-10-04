package com.hzjytech.hades.desginpattern.flyweightpattern.example;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by zhanghehe on 2017/10/4.
 */

public abstract class AbstractFile {

    public abstract String getFileType();

    public void display(int[] location,String size){
        LogOut.println("location is ("+location[0]+","+location[1]+"),size="+ size);
    }
}
