package com.kotlin.note.moviesdemo.application

import android.app.Application
import com.kotlin.note.moviesdemo.Url
import com.kotlin.note.moviesdemo.dagger.AppComponent
import com.kotlin.note.moviesdemo.dagger.AppModule
import com.kotlin.note.moviesdemo.dagger.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(Url.BASE)).build()
    }
}