package com.hzjytech.hades.desginpattern.visitpattern;

import android.util.Log;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import java.util.ArrayList;

/**
 * Created by Hades on 2017/11/25.
 */

class VisitPattern {
}

interface  Employee{
    public void accept(Department handler);
}

class FulltimeEmployee implements Employee{

    private String name;
    private double weeklyWage;
    private int workTime;

    public FulltimeEmployee(String name, double weeklyWage, int workTime) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeeklyWage() {
        return weeklyWage;
    }

    public void setWeeklyWage(double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public void accept(Department handler) {
        handler.visit(this);

    }
}

class ParttimeEmployee implements Employee{

    private String name;
    private double hourWage;
    private int workTime;

    public ParttimeEmployee(String name, double hourWage, int workTime) {
        this.name = name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourWage() {
        return hourWage;
    }

    public void setHourWage(double hourWage) {
        this.hourWage = hourWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public void accept(Department handler) {
        handler.visit(this);

    }
}

abstract class Department{
    public abstract void visit(FulltimeEmployee employee);

    public abstract void visit(ParttimeEmployee employee);
}

class FADepartment extends Department{

    @Override
    public void visit(FulltimeEmployee employee) {
        int workTime=employee.getWorkTime();
        double weekWage=employee.getWeeklyWage();
        if(workTime>40){
            weekWage=weekWage+(workTime-40)*100;
        }else if(workTime<40){
            weekWage=weekWage-(40-workTime)*80;

            if(weekWage<0){
                weekWage=0;
            }
        }
        LogOut.println("Fulltime"+employee.getName()+",weekWage"+weekWage);
    }

    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime=employee.getWorkTime();
        double hourWage=employee.getHourWage();
        LogOut.println("Parttime"+employee.getName()+",wage"+hourWage*workTime);

    }
}

class HRDepartment extends Department{

    @Override
    public void visit(FulltimeEmployee employee) {
        int worktime=employee.getWorkTime();
        LogOut.println("Fulltime:"+employee.getName()+",work time:"+worktime);
        if (worktime>40) {
            LogOut.println("Fulltime:"+employee.getName()+", over time:"+(worktime-40));

        }else if(worktime<40){
            LogOut.println("Fulltime:"+employee.getName()+", rest:"+(40-worktime));

        }
    }

    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime=employee.getWorkTime();
        LogOut.println("Parttime:"+employee.getName()+",work time"+workTime);

    }
}

class EmployeeList{
    private ArrayList<Employee> list=new ArrayList<>();

    public void addEmployee(Employee employee){
        list.add(employee);
    }

    public void accept(Department handler){
        for (Employee employee : list) {
            employee.accept(handler);
        }
    }
}