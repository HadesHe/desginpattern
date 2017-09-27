package com.hzjytech.hades.desginpattern.facadepattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

/**
 * Created by Hades on 2017/9/28.
 */

public class NewCipherMachine {

    public String Encypt(String plainText){
        LogOut.println("NewCipherMachine"+plainText);
        StringBuffer stringBuffer = null;

        char[] chars=plainText.toCharArray();
        for (char aChar : chars) {
            int temp=aChar;
            int key=10;
            if(aChar>='a'&&aChar<='z') {
                temp+=key%26;
                if (temp > 122) temp -= 26;
                if (temp < 97) temp += 26;
            }

            if(aChar>='A'&&aChar<='Z'){
                temp+=key%26;
                if(temp>90) temp-=26;
                if(temp<65) temp+=26;
            }
            stringBuffer.append(temp);
        }

        LogOut.println(stringBuffer.toString());
        return stringBuffer.toString();
    }
}
