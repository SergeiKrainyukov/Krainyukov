package com.sergeikrainyukov.myfavoritefilms.presentation.model

import com.sergeikrainyukov.myfavoritefilms.domain.entity.FilmItem

data class FilmListItem(
    val id: Int,
    val name: String,
    val image: String,
    val year: String,
) {
    companion object {
        fun fromModel(filmItem: FilmItem) = FilmListItem(
            id = filmItem.id,
            name = filmItem.name,
            image = filmItem.image,
            year = filmItem.year
        )
    }
}
