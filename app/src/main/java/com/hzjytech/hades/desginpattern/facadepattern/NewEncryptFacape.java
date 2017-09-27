package com.hzjytech.hades.desginpattern.facadepattern;

/**
 * Created by Hades on 2017/9/28.
 */

public class NewEncryptFacape implements AbstractEncryptFacade {

    private final FileReader reader;
    private final NewCipherMachine cipher;
    private final FileWrite write;

    public NewEncryptFacape(){
        reader=new FileReader();
        cipher=new NewCipherMachine();
        write=new FileWrite();
    }

    @Override
    public void FileEncrypt(String fileNameSrc, String fileNameDes) {
        String plainStr=reader.read(fileNameSrc);
        String encryptStr=cipher.Encypt(plainStr);
        write.write(encryptStr,fileNameDes);

    }
}
