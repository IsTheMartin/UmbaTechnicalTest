package me.ismartin.umbatechnicaltest.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [PopularMovies::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun popularMoviesDao(): PopularMoviesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "movies-db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}