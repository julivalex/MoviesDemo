package com.kotlin.note.moviesdemo.dagger

import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun createNetworkComponent(): NetworkComponent
}