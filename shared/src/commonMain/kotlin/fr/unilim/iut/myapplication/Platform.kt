package fr.unilim.iut.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform