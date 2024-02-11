package com.sergeikrainyukov.myfavoritefilms.domain.entity

data class Film(
    val id: Int,
    val name: String,
    val image: String,
    val year: Int,
)