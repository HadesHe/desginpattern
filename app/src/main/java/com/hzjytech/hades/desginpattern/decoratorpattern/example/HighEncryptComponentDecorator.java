package com.hzjytech.hades.desginpattern.decoratorpattern.example;

/**
 * Created by zhanghehe on 2017/9/27.
 */

public class HighEncryptComponentDecorator extends EncryptComponentDecorator {


    public HighEncryptComponentDecorator(EncryptComponent component) {
        super(component);
    }

    @Override
    public void baseEncrypt(String content) {
        super.baseEncrypt(content);

    }

    @Override
    public void normalEncrypt(String content) {
        System.out.println("HighEncrypt cannot");
    }

    @Override
    public void highEncrypt(String content) {

        System.out.println("HighEncrypt"+content);

    }


}
