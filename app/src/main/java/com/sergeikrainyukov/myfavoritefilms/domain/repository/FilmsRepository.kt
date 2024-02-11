package com.sergeikrainyukov.myfavoritefilms.domain.repository

import com.sergeikrainyukov.myfavoritefilms.domain.entity.Film

interface FilmsRepository {
    suspend fun getFilms(): List<Film>
    suspend fun getFilmById(id: Int): List<Film>
}