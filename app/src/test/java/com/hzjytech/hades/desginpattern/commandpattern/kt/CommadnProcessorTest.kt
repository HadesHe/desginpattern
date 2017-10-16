package com.hzjytech.hades.desginpattern.commandpattern.kt

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Hades on 2017/10/16.
 */
class CommadnProcessorTest{

    @Test
    fun testCommand() {
        CommadnProcessor()
                .addToQueue(OrderAddCommand(1L))
                .addToQueue(OrderAddCommand(2L))
                .addToQueue(OrderPayCommand(2L))
                .addToQueue(OrderPayCommand(1L))
                .processCommands();
    }
}