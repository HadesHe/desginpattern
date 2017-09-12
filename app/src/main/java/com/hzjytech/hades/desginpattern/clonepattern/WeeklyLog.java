package com.hzjytech.hades.desginpattern.clonepattern;

/**
 * Created by Hades on 2017/9/12.
 */

public class WeeklyLog implements Cloneable {

    private String name;
    private String date;

    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected WeeklyLog clone()  {

        Object obg=null;

        try {
            obg=super.clone();
            return ((WeeklyLog) obg);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
