package com.hzjytech.hades.desginpattern.decoratorpattern.kt

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Hades on 2017/9/27.
 */
class EnhancedCoffeeMachineTest{
    @Test
    fun testDecorator() {
        val normalMachine=NormalCoffeeMachine()
        val enhancedMachine=EnhancedCoffeeMachine(normalMachine)

        enhancedMachine.makeSmallCoffee()
        enhancedMachine.makeLargeCoffee()
        enhancedMachine.makeCoffeeWithMilk()

    }
}