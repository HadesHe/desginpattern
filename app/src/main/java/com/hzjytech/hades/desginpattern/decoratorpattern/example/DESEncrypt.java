package com.hzjytech.hades.desginpattern.decoratorpattern.example;

/**
 * Created by Hades on 2017/9/27.
 */

public class DESEncrypt extends EncryptComponent {
    @Override
    public String baseEncrypt(String content) {
        System.out.println("DES Encrypt"+content);
        return content;
    }
}
