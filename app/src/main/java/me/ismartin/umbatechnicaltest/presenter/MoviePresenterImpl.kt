package me.ismartin.umbatechnicaltest.presenter

import me.ismartin.umbatechnicaltest.model.models.Movie
import me.ismartin.umbatechnicaltest.model.MovieInteractorImpl
import me.ismartin.umbatechnicaltest.view.MoviesView

class MoviePresenterImpl(var movieView: MoviesView): MoviePresenter {

    private var movieInteractor = MovieInteractorImpl(this)
    //private var popularMovieRepository = PopularMovieRepositoryImpl()

    override fun getLatestMovies() {
        movieInteractor.getLatestMoviesApi()
    }

    override fun showLatestMovies(movies: ArrayList<Movie>) {
       movieView.showLatestMovies(movies)
    }

    override fun getPopularMovies(page: Int) {
        /*val popularMovies = popularMovieRepository.getAll()
        if(popularMovies.isEmpty()) {*/
            movieInteractor.getPopularMoviesApi(page)
        /*} else {
            val moviesJson = Gson().toJson(popularMovies)
            val movies = Gson().fromJson(moviesJson, Array<Movie>::class.java)
            movieView.showPopularMovies(movies.toCollection(ArrayList()))
        }*/
    }

    override fun showPopularMovies(movies: ArrayList<Movie>) {
       /* for(movie in movies) {
            val movieJson = Gson().toJson(movie)
            val popularMovie = Gson().fromJson(movieJson, PopularMovies::class.java)
            popularMovieRepository.insertAll(popularMovie)
        }

        val popularMovies = popularMovieRepository.getAll()
        val moviesJson = Gson().toJson(popularMovies)
        val moviesArrayList = Gson().fromJson(moviesJson, Array<Movie>::class.java)
        movieView.showPopularMovies(moviesArrayList.toCollection(ArrayList()))*/
        movieView.showPopularMovies(movies)
    }

    override fun getUpcomingMovies() {
        movieInteractor.getUpcomingMoviesApi()
    }

    override fun showUpcomingMovies(movies: ArrayList<Movie>) {
        movieView.showUpcomingMovies(movies)
    }
}