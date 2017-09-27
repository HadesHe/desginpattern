package com.hzjytech.hades.desginpattern.facadepattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by Hades on 2017/9/28.
 */

public class CipherMachine {
    public String encrypt(String plainText){
        LogOut.println("Cipher Encrypt");
        StringBuffer stringBuffer=new StringBuffer();
        char[] chars=plainText.toCharArray();
        for (char aChar : chars) {
            String s= String.valueOf((aChar%7));
            stringBuffer.append(s);
        }
        LogOut.println(stringBuffer.toString());
        return stringBuffer.toString();

    }

}
