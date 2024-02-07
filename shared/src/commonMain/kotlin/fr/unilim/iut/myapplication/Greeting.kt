package fr.unilim.iut.myapplication

import fr.unilim.iut.myapplication.ageCalculator.getAgeCalculator

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(param:String): String {
        val values = param.split(';')
        val name = values[0]
        val age = getAgeCalculator().computeAge(values[1].toInt())

        return "Hello $name vous avez $age ans!"
    }
}