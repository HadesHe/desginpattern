package com.hzjytech.hades.desginpattern.chainresponsibitlity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/10/14.
 */
public class ApproverTest {

    @Test
    public void testChainResponsibility() throws Exception {
        Approver wjzhang,rhuang,gyang,jguo,meeting;
        wjzhang=new Director("张无忌");
        rhuang=new Manager("黄蓉");
        gyang=new VicePresident("杨过");
        jguo=new President("郭靖");
        meeting=new Congress("董事会");

        wjzhang.setSuccessor(rhuang);
        rhuang.setSuccessor(gyang);
        gyang.setSuccessor(jguo);
        jguo.setSuccessor(meeting);


        PurchaseRequest pr1=new PurchaseRequest(45000,1001,"购买椅子");
        wjzhang.processRequest(pr1);

        PurchaseRequest pr2=new PurchaseRequest(60000,1002,"购买小弟");
        wjzhang.processRequest(pr2);


        PurchaseRequest pr3=new PurchaseRequest(165000,1003,"购买波多老师");
        wjzhang.processRequest(pr3);

        PurchaseRequest pr4=new PurchaseRequest(800000,1006,"马拉蒂尼");
        wjzhang.processRequest(pr4);
    }
}