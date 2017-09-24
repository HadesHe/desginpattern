package com.hzjytech.hades.desginpattern.bridgepattern.example;

/**
 * Created by zhanghehe on 2017/9/24.
 */

public class PdfReader extends ReaderFile {
    @Override
    public void typeChange() {
        System.out.println("change to pdf");
    }
}
