package com.hzjytech.hades.desginpattern.chainresponsibitlity.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/10/15.
 */
public class VacateApproveTest {

    @Test
    public void name() throws Exception {

        Request request1=new Request("黑九喵",1);
        Request request9=new Request("黑九喵",9);
        Request request29=new Request("黑九喵",29);
        Request request31=new Request("黑九喵",31);

        VacateApprove zhuren=new Zhuren("逍遥");
        VacateApprove wangjingli=new Jingli("大鱼");
        VacateApprove wangzongjingli=new ZongJingli("亚纶");


        zhuren.setVacateApprove(wangjingli);
        wangjingli.setVacateApprove(wangzongjingli);

        zhuren.handleVacateApprove(request1);

        zhuren.handleVacateApprove(request9);
        zhuren.handleVacateApprove(request29);
        zhuren.handleVacateApprove(request31);
    }
}