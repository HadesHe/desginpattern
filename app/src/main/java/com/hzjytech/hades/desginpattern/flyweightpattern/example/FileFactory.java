package com.hzjytech.hades.desginpattern.flyweightpattern.example;

import java.util.Hashtable;

/**
 * Created by zhanghehe on 2017/10/4.
 */

public class FileFactory {
    private static final FileFactory ourInstance = new FileFactory();

    private Hashtable<String, AbstractFile> ht;

    private FileFactory() {
        ht=new Hashtable<>();
        AnimateFile animateFile=new AnimateFile();
        ht.put("A",animateFile);
        ImageFile imageFile=new ImageFile();
        ht.put("I",imageFile);
        VideoFile videoFile=new VideoFile();
        ht.put("V",videoFile);
    }

    public static FileFactory getInstance() {
        return ourInstance;
    }

    public AbstractFile getFile(String type){
        return ht.get(type);
    }

}