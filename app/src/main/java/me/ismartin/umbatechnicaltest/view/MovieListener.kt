package me.ismartin.umbatechnicaltest.view

import me.ismartin.umbatechnicaltest.model.models.Movie

interface MovieListener {

    fun onClickItem(movieSelected: Movie)

}