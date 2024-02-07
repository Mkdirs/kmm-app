package fr.unilim.iut.myapplication.ageCalculator

interface AgeCalculator {
    fun computeAge(birthYear: Int) : Int
}

expect fun getAgeCalculator() : AgeCalculator