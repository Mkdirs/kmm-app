package fr.unilim.iut.myapplication.ageCalculator

import java.util.Calendar

class AndroidAgeCalculator : AgeCalculator {
    override fun computeAge(birthYear: Int): Int {
        val cal = Calendar.getInstance()

        return cal.get(Calendar.YEAR) - birthYear
    }
}

actual fun getAgeCalculator() : AgeCalculator = AndroidAgeCalculator()