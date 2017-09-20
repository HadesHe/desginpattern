package com.hzjytech.hades.desginpattern.adapterpattern.example;

/**
 * Created by Hades on 2017/9/20.
 */

public class EncryptAdapter implements EncryptOperator{

    private final DESEncrypt desEncrypt;
    private final AESEncrypt aesEncrypt;

    public EncryptAdapter() {
        this.aesEncrypt=new AESEncrypt();
        this.desEncrypt=new DESEncrypt();
    }

    @Override
    public String keyWordEncrypt(String keyword) {
        return aesEncrypt.encrypt(keyword);
    }

    @Override
    public String emailEncrypt(String email) {
        return desEncrypt.encrypt(email);
    }
}
