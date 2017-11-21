package com.hzjytech.hades.desginpattern.templatepattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/11/21.
 */
public class AccountTest {

    @Test
    public void testProgramErrorPassword() throws Exception {
        Account account;
        account=new CurrentAccount();
        account.handle("aaaa","1111");
    }

    @Test
    public void testProgramCurrentAccount() throws Exception {
        Account account=new CurrentAccount();
        account.handle("laowang","123456");
    }


    @Test
    public void testProgramSaveingAccount() throws Exception {
        Account account=new SavingAccount();
        account.handle("laowang","123456");
    }
}