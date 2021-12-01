package com.example.s205452lykkehjulet

import android.util.Log
import kotlin.random.Random

class Word {
    val categories = listOf<String>("Country", "City", "Codelanguage")
    val country = listOf<String>("Danmark", "Sverige")
    val city = listOf<String>("Ballerup", "Lyngby", "London", "Berlin")
    val codelanguage = listOf<String>("Kotlin", "Java", "Python")
    var splitWord: List<String> = listOf()
    val randomCategoryIndex = Random.nextInt(0,categories.size)
    val category = categories[randomCategoryIndex].lowercase()

    fun generateWord() :List<String>{
        when(category){
            "country" -> splitWord = country[Random.nextInt(0,country.size)].uppercase().split("")
            "city" -> splitWord =  city[Random.nextInt(0,city.size)].uppercase().split("")
            "codelanguage" -> splitWord =  codelanguage[Random.nextInt(0,codelanguage.size)].uppercase().split("")
        }
        // https://www.tutorialkart.com/kotlin/kotlin-filter-characters-of-string/
        splitWord = splitWord.filter { it -> !it.equals("") } // split results in empty char at beginning and end of string. Therefore filter is used to remove them

        return splitWord
    }

    fun getWordCategory(): String {
        return category
    }
}