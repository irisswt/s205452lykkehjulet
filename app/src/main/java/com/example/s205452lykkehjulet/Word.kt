package com.example.s205452lykkehjulet

import kotlin.random.Random

class Word {
    val categories = listOf<String>("Land", "By", "Kodesprog")
    val land = listOf<String>("Danmark", "Sverige")
    val by = listOf<String>("Ballerup", "Lyngby", "London", "Berlin")
    val kodesprog = listOf<String>("Kotlin", "Java", "Python")

    fun generateWord(): String{
        val randomCategoryIndex = Random.nextInt(0,categories.size)
        val category = categories[randomCategoryIndex]
        if(category.lowercase().equals("land")){
            val randomIndex = Random.nextInt(0,land.size)
            return land[randomIndex].uppercase()
        } else if(category.lowercase().equals("by")){
            val randomIndex = Random.nextInt(0,by.size)
            return by[randomIndex].uppercase()
        }
        else if(category.lowercase().equals("kodesprog")){
            val randomIndex = Random.nextInt(0,kodesprog.size)
            return kodesprog[randomIndex].uppercase()
        }
        else return "NULL"

    }
}