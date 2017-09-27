package com.hzjytech.hades.desginpattern.decoratorpattern.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/9/27.
 */
public class EncryptComponentDecoratorTest {

    @Test
    public void testDecotator(){
        EncryptComponent encryptComponent=new AESEncrypt();

        EncryptComponentDecorator decorator=new HighEncryptComponentDecorator(encryptComponent);

        decorator.baseEncrypt("---");
        decorator.highEncrypt("---");
        decorator.normalEncrypt("----");

        EncryptComponentDecorator decorator1=new NormalEncryptComponentDecorator(encryptComponent);
        decorator1.baseEncrypt("111");
        decorator1.normalEncrypt("111");
        decorator1.highEncrypt("1111");
    }

}