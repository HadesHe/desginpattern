package com.hzjytech.hades.desginpattern.builderpattern;

/**
 * Created by Hades on 2017/9/12.
 */

public abstract class ActorBuilder {

    protected  Actor actor=new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairstyle();

    public Actor createActor(){
        return actor;
    }

}
