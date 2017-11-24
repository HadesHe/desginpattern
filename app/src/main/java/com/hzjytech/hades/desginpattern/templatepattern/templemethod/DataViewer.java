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

    public boolean isNotXmlData(){
        return true;
    }

    public void process(){
        getData();
        if(isNotXmlData()){
            convertData();
        }
        displayData();
    }
}

class XmlDataView extends DataViewer {

    @Override
    public void getData() {
        LogOut.println("Get Data from XML");

    }

    @Override
    public void displayData() {
        LogOut.println("Bar graph display data");

    }

    @Override
    public boolean isNotXmlData() {
        return false;
    }
}
