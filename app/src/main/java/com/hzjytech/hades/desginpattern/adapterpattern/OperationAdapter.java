package com.hzjytech.hades.desginpattern.adapterpattern;

/**
 * Created by zhanghehe on 2017/9/19.
 */

public class OperationAdapter implements ScoreOperation {
    private QuickSort sortObj;
    private BinarySearch searchObj;

    public OperationAdapter(){
        sortObj=new QuickSort();
        searchObj=new BinarySearch();
    }
    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    @Override
    public int search(int[] arrat, int key) {
        return searchObj.binarySearch(arrat,key);
    }
}
