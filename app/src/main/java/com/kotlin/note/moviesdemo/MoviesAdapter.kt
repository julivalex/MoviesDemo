package com.kotlin.note.moviesdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie_layout.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_layout, parent, false)

        return MovieViewHolder(
            view,
            view.movieTitle,
            view.movieGenre,
            view.movieYear,
            view.movieAvatar
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = movies[position]
        holder.bindModel(movie)
    }

    fun setMovies(data: List<Movie>) {
        movies.addAll(data)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(
        itemView: View,
        private val movieTitleTxt: TextView,
        private val movieGenreTxt: TextView,
        private val movieYearTxt: TextView,
        private val movieAvatarImage: ImageView
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindModel(movie: Movie) {
            movieTitleTxt.text = movie.title
            movieGenreTxt.text = movie.genre
            movieYearTxt.text = movie.year
            Glide
                .with(itemView.context)
                .load(movie.poster)
                .into(movieAvatarImage)
        }
    }
}