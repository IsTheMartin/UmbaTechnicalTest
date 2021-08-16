package me.ismartin.umbatechnicaltest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.ismartin.umbatechnicaltest.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        private const val TAG = "Main"
    }
}