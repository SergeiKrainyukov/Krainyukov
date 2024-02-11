package com.sergeikrainyukov.myfavoritefilms.domain.useCase

import com.sergeikrainyukov.myfavoritefilms.domain.repository.FilmsRepository
import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private val filmsRepository: FilmsRepository
) {
    suspend operator fun invoke(id: Int) = filmsRepository.getFilmById(id)
}