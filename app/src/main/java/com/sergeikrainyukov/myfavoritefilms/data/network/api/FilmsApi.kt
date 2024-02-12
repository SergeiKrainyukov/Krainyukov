package com.sergeikrainyukov.myfavoritefilms.data.network.api

import com.sergeikrainyukov.myfavoritefilms.data.network.dto.FilmDto
import com.sergeikrainyukov.myfavoritefilms.data.network.dto.FilmsListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmsApi {
    @GET("/api/v2.2/films/top")
    suspend fun getFilms(@Query("type") type: String): FilmsListDto

    @GET("/api/v2.2/films/{id}")
    suspend fun getFilm(@Path("id") id: Int): FilmDto
}