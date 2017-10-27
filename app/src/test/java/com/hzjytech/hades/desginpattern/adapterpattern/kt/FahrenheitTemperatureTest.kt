package com.hzjytech.hades.desginpattern.adapterpattern.kt

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Hades on 2017/10/27.
 */
class FahrenheitTemperatureTest{


    @Test
    fun testAdapter() {
        val celsiusTemperature=CelsiusTemperature(0.0)

        val fahrenheitTemperature=FahrenheitTemperature(celsiusTemperature)

        celsiusTemperature.temperature=36.6

        println("${celsiusTemperature.temperature}C->${fahrenheitTemperature.temperature} F")

        fahrenheitTemperature.temperature=100.0

        println("${fahrenheitTemperature.temperature}F-> ${celsiusTemperature.temperature} C")


    }
}