package com.hzjytech.hades.desginpattern.decoratorpattern.example;

/**
 * Created by zhanghehe on 2017/9/27.
 */

public abstract class EncryptComponentDecorator extends EncryptComponent {

    private final EncryptComponent component;

    public EncryptComponentDecorator(EncryptComponent component){
        this.component=component;
    }

    @Override
    public void baseEncrypt(String content) {
        component.baseEncrypt(content);
    }

    public abstract void normalEncrypt(String content);

    public abstract void highEncrypt(String content);
}
