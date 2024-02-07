package fr.unilim.iut.myapplication.ageCalculator

class IOSAgeCalculator : AgeCalculator{
    override fun computeAge(birthYear: Int): Int {
        //TODO: implémenter

        return -1
    }
}
actual fun getAgeCalculator() : AgeCalculator = IOSAgeCalculator()