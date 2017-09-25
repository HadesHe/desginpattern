package com.hzjytech.hades.desginpattern.singlepattern.example

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Hades on 2017/9/25.
 */
class PrinterDriverTest{
    @Test
    fun main(){
        println("Start")
        PrinterDriver.print()
        PrinterDriver.print()
    }
}