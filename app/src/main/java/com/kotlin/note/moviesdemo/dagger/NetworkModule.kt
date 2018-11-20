package com.kotlin.note.moviesdemo.dagger

import com.kotlin.note.moviesdemo.ApiMovies
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideApiMovies(retrofit: Retrofit): ApiMovies = retrofit.create(ApiMovies::class.java)
}