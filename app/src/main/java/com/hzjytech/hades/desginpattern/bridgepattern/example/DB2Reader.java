package com.hzjytech.hades.desginpattern.bridgepattern.example;

/**
 * Created by zhanghehe on 2017/9/24.
 */

public class DB2Reader implements DatasetReader {
    @Override
    public String readFile(String name) {
        return "DB2 reader"+name;
    }
}
