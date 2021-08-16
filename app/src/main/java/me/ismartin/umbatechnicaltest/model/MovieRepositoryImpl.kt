package me.ismartin.umbatechnicaltest.model

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import me.ismartin.umbatechnicaltest.model.models.Movie
import me.ismartin.umbatechnicaltest.presenter.MoviePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryImpl(var moviePresenter: MoviePresenter): MovieRepository {

    override fun getLatestMoviesApi() {
        TODO("Not yet implemented")
    }

    override fun getPopularMoviesApi(page: Int) {
        val movies = ArrayList<Movie>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getPopularMovies(page)
        call.enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("results")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Gson().fromJson(jsonObject, Movie::class.java)
                    movies.add(coupon)
                }

                moviePresenter.showPopularMovies(movies)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message!!)
                t.printStackTrace()
            }
        })
    }

    override fun getUpcomingMoviesApi() {
        val movies = ArrayList<Movie>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getUpcomingMovies()
        call.enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("results")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Gson().fromJson(jsonObject, Movie::class.java)
                    movies.add(coupon)
                }

                moviePresenter.showUpcomingMovies(movies)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message!!)
                t.printStackTrace()
            }
        })
    }
}