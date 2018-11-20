package com.kotlin.note.moviesdemo.dagger

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val baseUrl: String) {

    @AppScope
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @AppScope
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @AppScope
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        callAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(gsonConverterFactory)
        .build()


}