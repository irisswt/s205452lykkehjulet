package com.example.s205452lykkehjulet

import kotlin.random.Random

class WheelOption{

    enum class WheelOption {
        POINTS_100,
        POINTS_500,
        POINTS_750,
        POINTS_1000,
        POINTS_1500,
        EXTRA_TURN,
        MISS_TURN,
        BANKRUPT
    }

    fun randomWheelOption(): WheelOption {
        return WheelOption.values()[Random.nextInt(0, WheelOption.values().size)]
    }
}