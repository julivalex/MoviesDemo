package com.kotlin.note.moviesdemo

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiMovies {

    @GET(value = "/filippella/Sample-API-Files/master/json/movies-api.json")
    fun getMovies() : Observable<MovieResponse>
}