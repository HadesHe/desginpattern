package com.hzjytech.hades.desginpattern.adapterpattern.example;

import com.hzjytech.hades.desginpattern.adapterpattern.OperationAdapter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/9/20.
 */
public class EncryptAdapterTest {


    @Test
    public void testEncryptExample() throws Exception {
        EncryptAdapter adapter=new EncryptAdapter();

        System.out.println(adapter.emailEncrypt("email"));
        System.out.println(adapter.keyWordEncrypt("keyword"));

    }
}