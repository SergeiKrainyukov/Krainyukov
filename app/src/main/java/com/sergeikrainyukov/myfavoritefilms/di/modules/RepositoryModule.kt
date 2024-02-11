package com.sergeikrainyukov.myfavoritefilms.di.modules

import com.sergeikrainyukov.myfavoritefilms.data.repository.FilmsRepositoryImpl
import com.sergeikrainyukov.myfavoritefilms.domain.repository.FilmsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideFilmsRepository(repository: FilmsRepositoryImpl): FilmsRepository
}