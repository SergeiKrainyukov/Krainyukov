package com.sergeikrainyukov.myfavoritefilms.domain.entity

data class Film(
    val title: String,
    val image: String,
    val description: String,
    val genres: List<String>,
    val countries: List<String>
)