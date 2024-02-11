package com.sergeikrainyukov.myfavoritefilms.data.network.api

import com.sergeikrainyukov.myfavoritefilms.data.network.dto.FilmsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmsApi {
    @GET("/api/v2.2/films/top")
    suspend fun getFilms(@Query("type") type: String): FilmsListDto
}