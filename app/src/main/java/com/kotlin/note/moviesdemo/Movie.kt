package com.kotlin.note.moviesdemo

data class Movie(
    var id: Int = 0,
    var title: String? = null,
    var year: String? = null,
    var genre: String? = null,
    var poster: String? = null
)