package com.hzjytech.hades.desginpattern.builderpattern;

/**
 * Created by Hades on 2017/9/12.
 */

public class ActorController {

    public Actor construct(ActorBuilder ab){
        Actor actor;
        ab.buildCostume();
        ab.buildFace();
        ab.buildHairstyle();
        ab.buildSex();
        ab.buildType();
        actor=ab.createActor();
        return actor;
    }
}
