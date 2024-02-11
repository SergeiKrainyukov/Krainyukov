package com.sergeikrainyukov.myfavoritefilms.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergeikrainyukov.myfavoritefilms.domain.useCase.GetFilmsUseCase
import com.sergeikrainyukov.myfavoritefilms.presentation.model.FilmListItem
import kotlinx.coroutines.flow.MutableStateFlow
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

    fun init() {
        viewModelScope.launch {
            try {
                val list = getFilmsUseCase().map { FilmListItem.fromModel(it) }
                _filmsState.emit(list)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onClickAddToFavorites(id: Int) {

    }
}