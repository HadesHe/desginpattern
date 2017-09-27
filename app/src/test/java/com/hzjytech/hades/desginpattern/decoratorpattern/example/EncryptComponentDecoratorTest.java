package com.hzjytech.hades.desginpattern.decoratorpattern.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/9/27.
 */
public class EncryptComponentDecoratorTest {

    @Test
    public void testDecotator(){
        EncryptComponent encryptComponent=new EncryptComponent() {
            @Override
            public void baseEncrypt(String content) {

            }
        };
    }

}