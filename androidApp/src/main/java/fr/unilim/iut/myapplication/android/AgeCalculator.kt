package fr.unilim.iut.myapplication.android

import java.util.Calendar

class AgeCalculator {
    fun computeAge(birthYear:Int) : Int {
        val calender = Calendar.getInstance()
        return calender.get(Calendar.YEAR) - birthYear
    }
}