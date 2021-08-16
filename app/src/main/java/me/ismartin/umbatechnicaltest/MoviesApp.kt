package me.ismartin.umbatechnicaltest

import android.app.Application
import android.content.Context

class MoviesApp: Application() {

    override fun onCreate() {
        super.onCreate()
        MoviesApp.context = applicationContext
    }

    companion object {
        @JvmStatic
        lateinit var context: Context
    }

}