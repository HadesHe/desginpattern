package com.hzjytech.hades.desginpattern.decoratorpattern.example;

/**
 * Created by Hades on 2017/9/27.
 */

public class AESEncrypt extends EncryptComponent {
    @Override
    public String baseEncrypt(String content) {
        System.out.println("AES Encrypt"+content);
        return content;
    }
}
