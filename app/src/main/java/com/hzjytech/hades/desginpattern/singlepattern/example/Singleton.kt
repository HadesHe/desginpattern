package com.hzjytech.hades.desginpattern.singlepattern.example

/**
 * Created by Hades on 2017/9/25.
 */
object PrinterDriver{
    init{
        println("Initializing with object:$this")
    }

    fun print()= println("Println with object :$this")
}
