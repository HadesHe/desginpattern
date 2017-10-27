package com.hzjytech.hades.desginpattern.adapterpattern.kt

/**
 * Created by Hades on 2017/10/27.
 */
interface Temperature{
    var temperature:Double
}

class CelsiusTemperature(override  var temperature: Double):Temperature

class FahrenheitTemperature(var celsiusTemperature: CelsiusTemperature):Temperature{
    override var temperature: Double
        get() = convertCelsiusToFahrenherit(celsiusTemperature.temperature)
        set(value) {
            celsiusTemperature.temperature=convertFahrenheitToCelsius(value)
        }

    private fun convertFahrenheitToCelsius(f: Double): Double =(f-32)*5/9

    private fun convertCelsiusToFahrenherit(c: Double): Double=(c*9/5)+32

}