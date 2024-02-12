package com.sergeikrainyukov.myfavoritefilms.presentation.model

import com.sergeikrainyukov.myfavoritefilms.domain.entity.Film

data class FilmUI(
    val title: String,
    val image: String,
    val description: String,
    val genres: String,
    val countries: String
) {
    companion object {
        fun fromModel(film: Film) = FilmUI(
            title = film.title,
            image = film.image,
            description = film.description,
            genres = film.genres.joinToString { it },
            countries = film.countries.joinToString { it }
        )
    }
}
