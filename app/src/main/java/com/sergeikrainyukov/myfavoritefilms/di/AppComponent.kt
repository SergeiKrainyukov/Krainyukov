package com.sergeikrainyukov.myfavoritefilms.di

import com.sergeikrainyukov.myfavoritefilms.di.modules.AppModule
import com.sergeikrainyukov.myfavoritefilms.di.modules.NetworkModule
import com.sergeikrainyukov.myfavoritefilms.di.modules.RepositoryModule
import com.sergeikrainyukov.myfavoritefilms.di.modules.ViewModelModule
import com.sergeikrainyukov.myfavoritefilms.presentation.fragments.FilmDescriptionFragment
import com.sergeikrainyukov.myfavoritefilms.presentation.fragments.FilmsListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(filmsListFragment: FilmsListFragment)

    fun inject(filmDescriptionFragment: FilmDescriptionFragment)

}