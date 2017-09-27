package com.hzjytech.hades.desginpattern.decoratorpattern.example;

/**
 * Created by zhanghehe on 2017/9/27.
 */

public class HighEncryptComponentDecorator extends EncryptComponentDecorator {


    public HighEncryptComponentDecorator(EncryptComponent component) {
        super(component);
    }

    @Override
    public String baseEncrypt(String content) {
        return super.baseEncrypt(content);

    }

    @Override
    public void normalEncrypt(String content) {

        System.out.println(component.getClass().getSimpleName()+"HighEncrypt "+super.baseEncrypt(content));
    }

    @Override
    public void highEncrypt(String content) {

        System.out.println(component.getClass().getSimpleName()+"HighEncrypt"+content);

    }


}
