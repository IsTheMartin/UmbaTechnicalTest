package me.ismartin.umbatechnicaltest.model

import me.ismartin.umbatechnicaltest.presenter.MovieDetailPresenter

class MovieDetailInteractorImpl(var movieDetailPresenter: MovieDetailPresenter): MovieDetailInteractor {

    private var movieDetailRepository = MovieDetailRepositoryImpl(movieDetailPresenter)

    override fun getMovieDetailApi(movieId: Int) {
        movieDetailRepository.getMovieApi(movieId)
    }
}