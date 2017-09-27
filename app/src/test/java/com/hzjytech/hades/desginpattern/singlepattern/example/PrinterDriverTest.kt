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

    @Test
    fun testSon() {

        Son().showI();
    }
}

open class Only{
    val i:Int=5
}

class Son: Only() {

    fun showI():Unit{
        println("your son is "+i+" years old")
    }

}