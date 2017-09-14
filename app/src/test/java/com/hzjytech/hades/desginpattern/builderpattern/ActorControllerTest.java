package com.hzjytech.hades.desginpattern.builderpattern;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;


/**
 * Created by Hades on 2017/9/12.
 */
public class ActorControllerTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {

        ActorBuilder heroBuilder = new HeroBuilder();
        ActorBuilder angelBuilder = new AngelBuilder();
        ActorBuilder devilBuilder = new DevilBuilder();
        ActorBuilder actorBuilder = new ActorBuilder() {
            @Override
            public void buildType() {
                actor.setType("SuperHero");
            }

            @Override
            public void buildSex() {
                actor.setSex("男性");

            }

            @Override
            public void buildFace() {
                actor.setFace("超级帅气");

            }

            @Override
            public void buildCostume() {
                actor.setCostume("披风");

            }

            @Override
            public void buildHairstyle() {
                actor.setHairstyle("光头");

            }
        };

        Actor heroActor = heroBuilder.construct();


        out(heroActor);
        Actor angleActor = angelBuilder.construct();

        out(angleActor);
        Actor devilActor = devilBuilder.construct();

        out(devilActor);
        Actor customActor = actorBuilder.construct();

        out(customActor);

    }

    private void out(Actor actor) {
        System.out.println(actor.getClass().getSimpleName() + actor.getType() + actor.getSex() + actor.getFace() + actor.getCostume() + actor.getHairstyle());

    }
}