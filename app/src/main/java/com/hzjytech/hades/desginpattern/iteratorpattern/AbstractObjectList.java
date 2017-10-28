package com.hzjytech.hades.desginpattern.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hades on 2017/10/23.
 */

abstract class AbstractObjectList {

    protected List<Object> objects=new ArrayList<>();

    public AbstractObjectList(List objects){
        this.objects=objects;
    }

    public void addObject(Object obj){
        objects.add(obj);
    }

    public void removeObject(Object obj){
        this.objects.remove(obj);
    }

    public abstract AbstractIterator createIterator();

    public List getObjects(){
        return this.objects;
    }

}

class ProductList extends AbstractObjectList{

    public ProductList(List objects) {
        super(objects);
    }

    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}

class ProductIterator implements AbstractIterator{

    private final ProductList productList;
    private final List products;
    private int cursor1;
    private int cursor2;

    public ProductIterator(ProductList productList) {
        this.productList=productList;
        this.products=productList.getObjects();
        cursor1=0;
        cursor2=products.size()-1;
    }

    @Override
    public void next() {
        if(cursor1<products.size()){
            cursor1++;
        }

    }

    @Override
    public boolean isLast() {
        return (cursor1==products.size());
    }

    @Override
    public void previous() {
        if(cursor2>-1){
            cursor2--;
        }

    }

    @Override
    public boolean isFirst() {
        return (cursor2==-1);
    }

    @Override
    public Object getNextItem() {
        return products.get(cursor1);
    }

    @Override
    public Object getPreviousItem() {
        return products.get(cursor2);
    }
}

interface AbstractIterator{
    public void next();

    public boolean isLast();

    public void previous();

    public boolean isFirst();

    public Object getNextItem();

    public Object getPreviousItem();

}

class CustomList extends AbstractObjectList{

    public CustomList(List users){
        super(users);
    }

    @Override
    public AbstractIterator createIterator() {
        return new UserIterator();
    }

    private class UserIterator implements AbstractIterator{
        private int cursor1;
        private int cursor2;

        public UserIterator(){
            cursor1=0;
            cursor2=objects.size()-1;
        }

        @Override
        public void next() {
            if(cursor1<objects.size()){
                cursor1++;
            }
        }

        @Override
        public boolean isLast() {
            return (cursor1==objects.size());
        }

        @Override
        public void previous() {
            if(cursor2>-1){
                cursor2--;
            }
        }

        @Override
        public boolean isFirst() {
            return (cursor2==-1);
        }

        @Override
        public Object getNextItem() {
            return objects.get(cursor1);
        }

        @Override
        public Object getPreviousItem() {
            return objects.get(cursor2);
        }
    }
}
