package com.hzjytech.hades.desginpattern.statepattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/11/16.
 */
public class AccountStateTest {

    @Test
    public void testStatePattern() throws Exception {
        Account account=new Account("Small Bro",0.0);
        account.deposit(100000);
        account.withdraw(2000000);
        account.deposit(3000000);

        account.withdraw(4781748);
        account.withdraw(794729847);
        account.computeInterest();
    }
}