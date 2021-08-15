package me.ismartin.umbatechnicaltest.model

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiAdapter {

    val apiKey = "5419367130f384eccbc4865e943a00f6"
    val urlApi = "https://api.themoviedb.org"

    fun getClientService(): ApiService {
        val authInterceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder()
                .addQueryParameter("api_key", apiKey)
                //.addQueryParameter("format", "json")
                .addQueryParameter("language", "en-US")
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(url)
                .build()

            chain.proceed(newRequest)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(urlApi)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return  retrofit.create(ApiService::class.java)
    }

}