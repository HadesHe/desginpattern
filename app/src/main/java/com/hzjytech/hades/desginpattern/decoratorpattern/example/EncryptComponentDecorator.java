package com.hzjytech.hades.desginpattern.decoratorpattern.example;

/**
 * Created by zhanghehe on 2017/9/27.
 */

public abstract class EncryptComponentDecorator extends EncryptComponent {

    protected  EncryptComponent component;

    public EncryptComponentDecorator(EncryptComponent component){
        this.component=component;
    }

    @Override
    public String baseEncrypt(String content) {
        return component.baseEncrypt(content);
    }

    public abstract void normalEncrypt(String content);

    public abstract void highEncrypt(String content);
}
