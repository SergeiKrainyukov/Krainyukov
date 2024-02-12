package com.sergeikrainyukov.myfavoritefilms.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adaptumapp.di.AppViewModelFactory
import com.example.adaptumapp.di.ViewModelKey
import com.sergeikrainyukov.myfavoritefilms.presentation.viewModels.FilmDescriptionFragmentViewModel
import com.sergeikrainyukov.myfavoritefilms.presentation.viewModels.FilmsListFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FilmsListFragmentViewModel::class)
    internal abstract fun bindFilmsListFragmentViewModel(viewModel: FilmsListFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FilmDescriptionFragmentViewModel::class)
    internal abstract fun bindFilmDescriptionFragmentViewModel(viewModel: FilmDescriptionFragmentViewModel): ViewModel

}