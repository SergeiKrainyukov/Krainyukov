package com.sergeikrainyukov.myfavoritefilms.domain.repository

import com.sergeikrainyukov.myfavoritefilms.domain.entity.FilmItem

interface FilmsRepository {
    suspend fun getFilms(): List<FilmItem>
    suspend fun getFilmById(id: Int): List<FilmItem>
}