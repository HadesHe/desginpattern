package com.hzjytech.hades.desginpattern.commandpattern.kt

/**
 * Created by Hades on 2017/10/16.
 */
interface OrderCommand{
    fun execute()
}

class OrderAddCommand(val id:Long):OrderCommand{
    override fun execute() = println("adding order with id :$id")
}

class OrderPayCommand(val id:Long):OrderCommand{
    override fun execute() = println("paying for order with id:$id")
}

class CommadnProcessor{
    private val queque=ArrayList<OrderCommand>()

    fun addToQueue(orderCommand: OrderCommand):CommadnProcessor
            =apply { queque.add(orderCommand) }

    fun processCommands():CommadnProcessor=apply {
        queque.forEach { it.execute() }
        queque.clear()
    }
}

