package com.hzjytech.hades.desginpattern.compositepattern;

/**
 * Created by Hades on 2017/9/25.
 */

public class VideoFile extends AbstractFile {

    private final String name;

    public VideoFile(String name){
        this.name=name;
    }
    @Override
    public void add(AbstractFile c) {
        System.out.println(" VideoFile don't support add");

    }

    @Override
    public void delete(AbstractFile c) {
        System.out.println(" VideoFile don't support delete");


    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println(" VideoFile don't support getChild");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println(" name" +" kill virus");

    }
}
