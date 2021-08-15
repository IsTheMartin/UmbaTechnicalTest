package me.ismartin.umbatechnicaltest.presenter

import me.ismartin.umbatechnicaltest.model.models.MovieDetail

interface MovieDetailPresenter {

    fun getMovieDetails(movieId: Int)
    fun showMovieDetails(movieDetails: MovieDetail)
}