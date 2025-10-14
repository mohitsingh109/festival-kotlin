package org.example.com.festival.entity

enum class Genre(val value: String) {

    // var ==> if you want value can be modified
    // val ==> if we want immutable data

    ROCK("Rock"),
    JAZZ("Jazz"),
    HIPHOP("Hiphop"),
    CLASSICAL("Classical")
}