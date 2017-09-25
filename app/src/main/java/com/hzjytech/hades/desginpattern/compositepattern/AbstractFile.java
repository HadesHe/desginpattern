package com.hzjytech.hades.desginpattern.compositepattern;

/**
 * Created by Hades on 2017/9/25.
 */

public abstract class AbstractFile {
    public abstract void add(AbstractFile c);
    public abstract void delete(AbstractFile c);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}
