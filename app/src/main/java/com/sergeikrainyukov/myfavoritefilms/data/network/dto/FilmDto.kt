package com.sergeikrainyukov.myfavoritefilms.data.network.dto

import com.google.gson.annotations.SerializedName
import com.sergeikrainyukov.myfavoritefilms.domain.entity.Film

data class FilmDto(
    @SerializedName("nameRu") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("countries") val countries: List<Country>,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("posterUrl") val image: String,
) {
    fun toModel() = Film(
        title = title,
        image = image,
        description = description,
        genres = genres.map { it.title },
        countries = countries.map { it.title }
    )
}

data class Country(
    @SerializedName("country") val title: String,
)

data class Genre(
    @SerializedName("genre") val title: String,
)
