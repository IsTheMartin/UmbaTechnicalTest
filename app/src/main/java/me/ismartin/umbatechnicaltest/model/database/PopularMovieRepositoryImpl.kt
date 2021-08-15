package me.ismartin.umbatechnicaltest.model.database

import me.ismartin.umbatechnicaltest.MoviesApp

class PopularMovieRepositoryImpl: PopularMovieRepository {
    private val popularMoviesDao = AppDatabase.getInstance(MoviesApp.context).popularMoviesDao()
    private val moviesList: ArrayList<PopularMovies>

    init {
        moviesList = popularMoviesDao.getAll()
    }

    override fun getAll(): ArrayList<PopularMovies> {
        return popularMoviesDao.getAll()
    }

    override fun getById(id: Int): PopularMovies {
        return popularMoviesDao.getById(id)
    }

    override fun insertAll(vararg: PopularMovies) {
        popularMoviesDao.insertAll(vararg)
    }
}