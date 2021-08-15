package me.ismartin.umbatechnicaltest.view

import me.ismartin.umbatechnicaltest.model.models.Movie

interface MoviesView {

    fun getLatestMovies()
    fun showLatestMovies(movies: ArrayList<Movie>)

    fun getPopularMovies(page: Int)
    fun showPopularMovies(movies: ArrayList<Movie>)

    fun getUpcomingMovies()
    fun showUpcomingMovies(movies: ArrayList<Movie>)

}