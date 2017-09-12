package com.hzjytech.hades.desginpattern.builderpattern;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

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
        ActorController actorController=new ActorController();
        actorController.construct(new HeroBuilder());
    }
}