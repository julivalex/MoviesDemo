package com.kotlin.note.moviesdemo

import android.annotation.SuppressLint
import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.kotlin.note.moviesdemo.application.App
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MoviesAdapter

    @Inject
    lateinit var apiMovies: ApiMovies

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val app: Application = application
        if (app is App) {
            app.appComponent.createNetworkComponent().inject(this)
        }

        movieAdapter = MoviesAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.movies_list)
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = movieAdapter
        }

        val observable: Observable<MovieResponse> = apiMovies.getMovies()
        observable.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieAdapter.setMovies(it.data)
            }, {
                Log.d("LOG2", it.message)
                Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
            })

    }
}

