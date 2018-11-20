package com.kotlin.note.moviesdemo.dagger

import com.kotlin.note.moviesdemo.MainActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(activity: MainActivity)
}