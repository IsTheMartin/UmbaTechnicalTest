package me.ismartin.umbatechnicaltest.view

import me.ismartin.umbatechnicaltest.model.models.MovieDetail

interface MovieDetailsView {

    fun getMovieDetails(movieId: Int)
    fun showMovieDetails(movieDetails: MovieDetail)

}