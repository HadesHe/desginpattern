package com.hzjytech.hades.desginpattern.adapterpattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhanghehe on 2017/9/19.
 */
public class OperationAdapterTest {

    @Test
    public void testAdapter(){
        ScoreOperation scoreOperation;
        scoreOperation=new OperationAdapter();
        int scores[]={54,67,23,464,74,674,78};
        int result[];
        int score;

        println("成绩排序结果:");
        result=scoreOperation.sort(scores);

        for (int i : scores) {
            print(i+",");
        }
        println("");
        println("查找成绩 23");
        score=scoreOperation.search(result,23);
        if(score != -1){
            println("找到成绩23");
        }else{
            println("没找到成绩23");

        }

        println("查找成绩 90");
        score=scoreOperation.search(result,90);
        if(score != -1){
            println("找到成绩90");
        }else{
            println("没找到成绩90");

        }

    }

    private void print(String s) {
        System.out.print(s);
    }

    private void println(String s) {
        System.out.println(s);
    }

}