package com.sergeikrainyukov.myfavoritefilms.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergeikrainyukov.myfavoritefilms.domain.useCase.GetFilmsUseCase
import com.sergeikrainyukov.myfavoritefilms.presentation.model.FilmListItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class FilmsListFragmentViewModel @Inject constructor(
    private val getFilmsUseCase: GetFilmsUseCase
) : ViewModel() {

    private val _filmsState = MutableStateFlow<List<FilmListItem>?>(null)
    val filmsState: StateFlow<List<FilmListItem>?>
        get() = _filmsState.asStateFlow()

    private val _errorState = MutableSharedFlow<Unit>()
    val errorState: SharedFlow<Unit>
        get() = _errorState

    fun init() {
        viewModelScope.launch {
            try {
                val list = getFilmsUseCase().map { FilmListItem.fromModel(it) }
                _filmsState.emit(list)
            } catch (e: Exception) {
                e.printStackTrace()
                _errorState.emit(Unit)
            }
        }
    }

    fun onClickAddToFavorites(id: Int) {

    }
}