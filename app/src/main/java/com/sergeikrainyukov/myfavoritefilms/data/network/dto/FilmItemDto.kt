package com.sergeikrainyukov.myfavoritefilms.data.network.dto

import com.google.gson.annotations.SerializedName
import com.sergeikrainyukov.myfavoritefilms.domain.entity.FilmItem

data class FilmsListDto(
    @SerializedName("pagesCount") val id: Int,
    @SerializedName("films") val films: List<FilmItemDto>,
)

data class FilmItemDto(
    @SerializedName("filmId") val id: Int,
    @SerializedName("nameRu") val name: String,
    @SerializedName("posterUrl") val imageUrl: String,
    @SerializedName("year") val year: String
) {
    fun toModel() = FilmItem(
        id = id,
        name = name,
        image = imageUrl,
        year = year
    )
}
