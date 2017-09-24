package com.hzjytech.hades.desginpattern.bridgepattern.example;

/**
 * Created by zhanghehe on 2017/9/24.
 */

public class OracleReader implements DatasetReader {
    @Override
    public String readFile(String name) {

        return "Oracle reader"+name;
    }
}
