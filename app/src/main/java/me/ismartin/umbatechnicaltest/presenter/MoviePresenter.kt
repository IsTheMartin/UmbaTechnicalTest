package me.ismartin.umbatechnicaltest.presenter

import me.ismartin.umbatechnicaltest.model.models.Movie

interface MoviePresenter {

    fun getLatestMovies()
    fun showLatestMovies(movies: ArrayList<Movie>)

    fun getPopularMovies(page: Int)
    fun showPopularMovies(movies: ArrayList<Movie>)

    fun getUpcomingMovies()
    fun showUpcomingMovies(movies: ArrayList<Movie>)
}