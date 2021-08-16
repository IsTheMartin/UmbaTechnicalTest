package me.ismartin.umbatechnicaltest.model

interface MovieRepository {

    fun getLatestMoviesApi()
    fun getPopularMoviesApi(page: Int)
    fun getUpcomingMoviesApi()
}