package com.hzjytech.hades.desginpattern.facadepattern;

/**
 * Created by Hades on 2017/9/28.
 */

public class EncryptFacade {

    private final FileReader reader;
    private final CipherMachine cipher;
    private final FileWrite write;

    public EncryptFacade(){
        reader=new FileReader();
        cipher=new CipherMachine();
        write=new FileWrite();
    }

    public void fileEncrypt(String filenameSrc,String fileNameDes){
        String plianStr=reader.read(filenameSrc);
        String encryptStr=cipher.encrypt(plianStr);
        write.write(encryptStr,fileNameDes);
    }
}
