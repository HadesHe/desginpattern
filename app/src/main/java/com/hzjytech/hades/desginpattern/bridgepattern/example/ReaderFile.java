package com.hzjytech.hades.desginpattern.bridgepattern.example;

/**
 * Created by zhanghehe on 2017/9/24.
 */

public abstract class ReaderFile {
    protected DatasetReader mDatasetReader;

    public void setmDatasetReader(DatasetReader mDatasetReader) {
        this.mDatasetReader = mDatasetReader;
        System.out.println(mDatasetReader.readFile("name" ));
    }

    public abstract void typeChange();
}
