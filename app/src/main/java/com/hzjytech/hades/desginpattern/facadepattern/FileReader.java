package com.hzjytech.hades.desginpattern.facadepattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by Hades on 2017/9/28.
 */

public class FileReader {

    public String read(String fileName){
        LogOut.println("FileReader fileName");
        return fileName;
    }

}
