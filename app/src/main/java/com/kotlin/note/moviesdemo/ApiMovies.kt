package com.kotlin.note.moviesdemo

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiMovies {

    @GET(value = Url.EXTENSION)
    fun getMovies() : Observable<MovieResponse>
}