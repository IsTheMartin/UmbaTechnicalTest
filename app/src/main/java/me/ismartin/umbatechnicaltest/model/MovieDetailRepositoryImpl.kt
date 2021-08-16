package me.ismartin.umbatechnicaltest.model

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import me.ismartin.umbatechnicaltest.model.models.MovieDetail
import me.ismartin.umbatechnicaltest.presenter.MovieDetailPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailRepositoryImpl(var movieDetailPresenter: MovieDetailPresenter): MovieDetailRepository {

    override fun getMovieApi(movieId: Int) {
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getMovieDetail(movieId)
        call.enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val movieDetail = Gson().fromJson(response.body(), MovieDetail::class.java)
                movieDetailPresenter.showMovieDetails(movieDetail)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message!!)
                t.printStackTrace()
            }
        })
    }
}