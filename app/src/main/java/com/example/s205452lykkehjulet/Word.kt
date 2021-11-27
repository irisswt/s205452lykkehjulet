package com.example.s205452lykkehjulet

import kotlin.random.Random

class Word {
    val categories = listOf<String>("Land", "By", "Kodesprog")
    val land = listOf<String>("Danmark", "Sverige")
    val by = listOf<String>("Ballerup", "Lyngby", "London", "Berlin")
    val kodesprog = listOf<String>("Kotlin", "Java", "Python")
    var splitWord: List<String> = listOf()

    fun generateWord() :List<String>{
        val randomCategoryIndex = Random.nextInt(0,categories.size)
        val category = categories[randomCategoryIndex].lowercase()
        when(category){
            "land" -> splitWord = land[Random.nextInt(0,land.size)].uppercase().split("")
            "by" -> splitWord =  by[Random.nextInt(0,by.size)].uppercase().split("")
            "kodesprog" -> splitWord =  kodesprog[Random.nextInt(0,kodesprog.size)].uppercase().split("")
        }
        return splitWord
    }
}