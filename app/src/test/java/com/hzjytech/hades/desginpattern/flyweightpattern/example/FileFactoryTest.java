package com.hzjytech.hades.desginpattern.flyweightpattern.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/10/4.
 */
public class FileFactoryTest {

    @Test
    public void testFileFactory() throws Exception{
        AbstractFile animate1=FileFactory.getInstance().getFile("A");
        AbstractFile animate2=FileFactory.getInstance().getFile("A");
        AbstractFile animate3=FileFactory.getInstance().getFile("A");
        AbstractFile imageFile=FileFactory.getInstance().getFile("I");
        AbstractFile videFile=FileFactory.getInstance().getFile("V");

        int[] diplayFile=new int[]{1,2};
        animate1.display(diplayFile,"large");

        int[] diplayFile2=new int[]{3,4};
        animate2.display(diplayFile2,"small");
    }

}