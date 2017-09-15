package com.hzjytech.hades.desginpattern.builderpattern;

/**
 * Created by Hades on 2017/9/12.
 */

public class DevilBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        actor.setSex("妖");

    }

    @Override
    public void buildFace() {
        actor.setFace("丑陋");

    }

    @Override
    public void buildCostume() {
        actor.setCostume("黑衣");

    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("光头");

    }

    @Override
    protected boolean isBareHeader() {
        return true;
    }
}
