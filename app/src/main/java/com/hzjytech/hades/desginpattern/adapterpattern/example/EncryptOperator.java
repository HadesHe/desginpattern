package com.hzjytech.hades.desginpattern.adapterpattern.example;

/**
 * Created by Hades on 2017/9/20.
 */

public interface EncryptOperator {

    String keyWordEncrypt(String keyword);

    String emailEncrypt(String email);

}
