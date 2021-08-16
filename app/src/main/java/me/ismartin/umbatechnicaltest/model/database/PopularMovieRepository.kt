package me.ismartin.umbatechnicaltest.model.database


interface PopularMovieRepository {

    fun getAll(): ArrayList<PopularMovies>
    fun getById(id: Int): PopularMovies
    fun insertAll(vararg: PopularMovies)

}