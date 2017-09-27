package com.hzjytech.hades.desginpattern.decoratorpattern.kt

/**
 * Created by Hades on 2017/9/27.
 */
interface CoffeeMachine{
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

class NormalCoffeeMachine:CoffeeMachine{
    override fun makeLargeCoffee() {
        println("Normal: Making large coffee")

    }

    override fun makeSmallCoffee() {
        println("Normal: Making small coffee")
    }

}

class EnhancedCoffeeMachine(val coffeeMachine: CoffeeMachine):CoffeeMachine by coffeeMachine{
    override fun makeLargeCoffee() {
        println("Enhanced: Making large coffee")
        coffeeMachine.makeLargeCoffee()
    }

    fun makeCoffeeWithMilk(){
        println("Enhanced: Making coffee with milk")
        coffeeMachine.makeSmallCoffee()
        println("Enhanced: Add milk")

    }
}