package com.hzjytech.hades.desginpattern.compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hades on 2017/9/25.
 */

public class Folder extends AbstractFile {

    private List<AbstractFile> fileList=new ArrayList<>();
    private String name;

    public Folder(String name){
        this.name=name;
    }

    @Override
    public void add(AbstractFile c) {
        fileList.add(c);

    }

    @Override
    public void delete(AbstractFile c) {
        fileList.remove(c);

    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("fold "+name+"kill virus");
        for (AbstractFile abstractFile : fileList) {
            abstractFile.killVirus();
        }

    }
}
