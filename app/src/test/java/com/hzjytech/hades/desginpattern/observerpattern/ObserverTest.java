package com.hzjytech.hades.desginpattern.observerpattern;

import org.junit.Test;

/**
 * Created by zhanghehe on 2017/11/14.
 */

public class ObserverTest {


    @Test
    public void testObserver() throws Exception {
        AllyControlCenter acc;
        acc=new ConcreteAllyControlCenter("Stay for it");
        Observer player1,player2,player3,player4;

        player1=new Player("老王");
        acc.join(player1);

        player2=new Player("小弟");
        acc.join(player2);

        player3=new Player("小司");
        acc.join(player3);

        player4=new Player("亚纶");
        acc.join(player4);

        player2.beAttacked(acc);




    }
}
