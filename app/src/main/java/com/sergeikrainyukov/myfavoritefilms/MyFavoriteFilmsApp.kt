package com.sergeikrainyukov.myfavoritefilms

import android.app.Application
import com.sergeikrainyukov.myfavoritefilms.di.DaggerAppComponent
import com.sergeikrainyukov.myfavoritefilms.di.modules.AppModule

class MyFavoriteFilmsApp : Application() {
    val appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
}