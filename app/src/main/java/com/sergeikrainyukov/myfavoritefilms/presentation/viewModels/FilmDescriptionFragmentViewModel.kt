package com.sergeikrainyukov.myfavoritefilms.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergeikrainyukov.myfavoritefilms.domain.useCase.GetFilmUseCase
import com.sergeikrainyukov.myfavoritefilms.presentation.model.FilmUI
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FilmDescriptionFragmentViewModel @Inject constructor(
    private val getFilmUseCase: GetFilmUseCase
) : ViewModel() {
    private val _filmState = MutableStateFlow<FilmUI?>(null)
    val filmState: StateFlow<FilmUI?>
        get() = _filmState.asStateFlow()

    private val _errorState = MutableSharedFlow<Unit>()
    val errorState: SharedFlow<Unit>
        get() = _errorState

    fun init(filmId: Int) {
        viewModelScope.launch {
            try {
                val film = FilmUI.fromModel(getFilmUseCase(filmId))
                _filmState.emit(film)
            } catch (e: Exception) {
                _errorState.emit(Unit)
                e.printStackTrace()
            }
        }
    }
}