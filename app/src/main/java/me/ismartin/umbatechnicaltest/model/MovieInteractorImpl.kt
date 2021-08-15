package me.ismartin.umbatechnicaltest.model

import me.ismartin.umbatechnicaltest.presenter.MoviePresenter

class MovieInteractorImpl(var moviePresenter: MoviePresenter) : MovieInteractor {

    private var movieRepository = MovieRepositoryImpl(moviePresenter)

    override fun getLatestMoviesApi() {
        TODO("Not yet implemented")
    }

    override fun getPopularMoviesApi(page: Int) {
        movieRepository.getPopularMoviesApi(page)
    }

    override fun getUpcomingMoviesApi() {
        movieRepository.getUpcomingMoviesApi()
    }
}