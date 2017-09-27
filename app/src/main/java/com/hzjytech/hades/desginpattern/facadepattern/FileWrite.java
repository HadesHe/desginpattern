package com.hzjytech.hades.desginpattern.facadepattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by Hades on 2017/9/28.
 */

public class FileWrite {
    public void write(String encryptStr,String fileNameDes){
        LogOut.println("File Write "+encryptStr+";"+fileNameDes);
    }
}
