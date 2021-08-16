package me.ismartin.umbatechnicaltest.presenter

import me.ismartin.umbatechnicaltest.model.MovieDetailInteractorImpl
import me.ismartin.umbatechnicaltest.model.models.MovieDetail
import me.ismartin.umbatechnicaltest.view.MovieDetailsView

class MovieDetailPresenterImpl(var movieDetailsView: MovieDetailsView): MovieDetailPresenter {

    private var movieDetailsInteractor = MovieDetailInteractorImpl(this)

    override fun getMovieDetails(movieId: Int) {
        movieDetailsInteractor.getMovieDetailApi(movieId)
    }

    override fun showMovieDetails(movieDetails: MovieDetail) {
        movieDetailsView.showMovieDetails(movieDetails)
    }
}