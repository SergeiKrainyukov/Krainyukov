package com.sergeikrainyukov.myfavoritefilms.data.repository

import com.sergeikrainyukov.myfavoritefilms.data.network.api.FilmsApi
import com.sergeikrainyukov.myfavoritefilms.domain.entity.FilmItem
import com.sergeikrainyukov.myfavoritefilms.domain.repository.FilmsRepository
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(
    private val filmsApi: FilmsApi
) : FilmsRepository {
    override suspend fun getFilms(): List<FilmItem> {
        return filmsApi.getFilms(type = "TOP_100_POPULAR_FILMS").films.map { it.toModel() }
    }

    override suspend fun getFilmById(id: Int): List<FilmItem> {
        return emptyList()
    }
}