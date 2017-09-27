package com.hzjytech.hades.desginpattern.facadepattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/9/28.
 */
public class EncryptFacadeTest {
    @Test
    public void fileEncrypt() throws Exception {
        EncryptFacade encryptFacade=new EncryptFacade();
        encryptFacade.fileEncrypt("src.txt","des.txt");
    }

}