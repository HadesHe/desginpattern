package com.hzjytech.hades.desginpattern.visitpattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/11/25.
 */
public class EmployeeTest {

    @Test
    public void testVisitPattern() throws Exception {
        EmployeeList list=new EmployeeList();

        Employee employee1,employee2,employee3,partime1,parttime2;

        employee1=new FulltimeEmployee("Wuji Zhang1",3200,45);
        employee2=new FulltimeEmployee("Guo Yang",2000,40);
        employee3=new FulltimeEmployee("Yu Duan",2400,38);

        partime1=new ParttimeEmployee("Qigong Hong",80,20);
        parttime2=new ParttimeEmployee("Jing Guo",60,18);

        list.addEmployee(employee1);
        list.addEmployee(employee2);
        list.addEmployee(employee3);

        list.addEmployee(partime1);
        list.addEmployee(parttime2);

        Department department;
        department=new HRDepartment();
        list.accept(department);
    }
}