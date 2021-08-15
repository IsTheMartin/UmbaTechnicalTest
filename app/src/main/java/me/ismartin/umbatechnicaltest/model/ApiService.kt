package me.ismartin.umbatechnicaltest.model

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/latest")
    fun getLatestMovies(): Call<JsonObject>

    @GET("/3/movie/popular")
    fun getPopularMovies(@Query("page") page: Int): Call<JsonObject>

    @GET("/3/movie/upcoming")
    fun getUpcomingMovies(): Call<JsonObject>

    @GET("/3/movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): Call<JsonObject>
}