package com.hzjytech.hades.desginpattern.clonepattern;

import java.io.Serializable;

/**
 * Created by Hades on 2017/9/12.
 */

public class Attachment implements Serializable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download(){
        System.out.println("下载文件名为："+name);
    }
}
