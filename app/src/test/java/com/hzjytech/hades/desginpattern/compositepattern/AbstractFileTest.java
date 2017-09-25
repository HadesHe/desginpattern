package com.hzjytech.hades.desginpattern.compositepattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/9/25.
 */
public class AbstractFileTest {

    @Test
    public void testCompositePattern() throws Exception {

        AbstractFile file1,file2,file3,file4,file5,folder1,folder2,folder3,folder4;

        folder1=new Folder("Sunny Folder");
        folder2=new Folder("videoFold");
        folder3=new Folder("textFold");
        folder4=new Folder("videoFold");

        file1=new ImageFile("mouse.jpg");
        file2=new ImageFile("tiger.gif");
        file3=new TextFile("九阴真经.txt");
        file4=new TextFile("葵花宝典.doc");
        file5=new VideoFile("笑傲江湖.avi");


        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);

        folder1.killVirus();



    }
}