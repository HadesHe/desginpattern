package com.hzjytech.hades.desginpattern.strategypattern;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hades on 2017/11/20.
 */
public class MovieTicketTest {

    @Test
    public void testMoviePrice() throws Exception {
        MovieTicket mt=new MovieTicket();
        double originalPrice=60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        LogOut.println("original Price"+originalPrice);
        LogOut.println("-----------------------------");

        Discount discount;
        discount=new VIPDiscount();
        mt.setDiscount(discount);

        currentPrice=mt.getPrice();
        LogOut.println("currentPrice"+currentPrice);
    }
}