package com.hzjytech.hades.desginpattern.templatepattern.templemethod;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by Hades on 2017/11/21.
 */

abstract class DataViewer {

    public abstract void getData();

    public void convertData(){
        LogOut.println("convert Data to XML");
    }

    public abstract void displayData();

    public

}
