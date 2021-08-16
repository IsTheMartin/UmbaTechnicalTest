package me.ismartin.umbatechnicaltest.model

interface MovieInteractor {

    fun getLatestMoviesApi()
    fun getPopularMoviesApi(page: Int)
    fun getUpcomingMoviesApi()

}