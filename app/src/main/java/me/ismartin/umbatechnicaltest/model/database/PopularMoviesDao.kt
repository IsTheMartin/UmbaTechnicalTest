package me.ismartin.umbatechnicaltest.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PopularMoviesDao {

    @Query("SELECT * FROM popular_movies")
    fun getAll(): ArrayList<PopularMovies>

    @Query("SELECT * FROM popular_movies WHERE id=:id")
    fun getById(id: Int): PopularMovies

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg: PopularMovies)
}