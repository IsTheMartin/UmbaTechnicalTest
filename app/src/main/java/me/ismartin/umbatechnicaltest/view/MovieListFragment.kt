package me.ismartin.umbatechnicaltest.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.ismartin.umbatechnicaltest.R
import me.ismartin.umbatechnicaltest.databinding.FragmentMovieListBinding
import me.ismartin.umbatechnicaltest.model.models.Movie
import me.ismartin.umbatechnicaltest.presenter.MoviePresenter
import me.ismartin.umbatechnicaltest.presenter.MoviePresenterImpl
import me.ismartin.umbatechnicaltest.utils.NetworkUtils
import me.ismartin.umbatechnicaltest.utils.invisible
import me.ismartin.umbatechnicaltest.utils.visible

class MovieListFragment : Fragment(R.layout.fragment_movie_list), MoviesView, MovieListener {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var moviePresenter: MoviePresenter
    private var menuSelected = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(layoutInflater, container, false)
        moviePresenter = MoviePresenterImpl(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()

        getMovies()
    }

    private fun setupViews() {
        with(binding.rvMovieList) {
            layoutManager = LinearLayoutManager(requireContext())
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if(!canScrollVertically(1)) {
                        //getMovies()
                    }
                }
            })
        }
        binding.btnTryReconnect.setOnClickListener { getMovies() }
        with(binding.tbMain) {
            inflateMenu(R.menu.main_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_popular_movies -> {
                        getPopularMovies(getNextPage())
                    }
                    R.id.menu_upcoming_movies -> {
                        getUpcomingMovies()
                    }
                    else -> {
                        Log.d(TAG, "Menu no configured")
                    }
                }
                changeToolbarTitle()
                false
            }
        }
    }

    private fun getNextPage(): Int {
        val itemsCount = binding.rvMovieList.adapter?.itemCount?: 0
        return 1/* if(itemsCount == 0) 1
        else (itemsCount / 20) + 1*/
    }

    private fun getMovies() {
        when(menuSelected) {
            0 -> getPopularMovies(getNextPage())
            1 -> getUpcomingMovies()
            2 -> getLatestMovies()
        }
        changeToolbarTitle()
    }

    private fun changeToolbarTitle() {
        with(binding.tbMain) {
            title = when (menuSelected) {
                0 -> "Popular movies"
                1 -> "Upcoming movies"
                2 -> "Latest movies"
                else -> "?"
            }
        }
    }

    private fun displayUIForInternetConnection(isConnected: Boolean) {
        if (isConnected) {
            binding.rvMovieList.visible()
            binding.btnTryReconnect.invisible()
            binding.tvNoInternetConnection.invisible()
        } else {
            binding.rvMovieList.invisible()
            binding.btnTryReconnect.visible()
            binding.tvNoInternetConnection.visible()
            binding.rvMovieList.adapter = MovieListAdapter(arrayListOf(), this)
        }
    }

    override fun getLatestMovies() {
        if (NetworkUtils().isNetworkAvailable(requireContext())) {
            moviePresenter.getLatestMovies()
        } else {
            displayUIForInternetConnection(false)
        }
    }

    override fun showLatestMovies(movies: ArrayList<Movie>) {
        displayUIForInternetConnection(true)
        binding.rvMovieList.adapter = MovieListAdapter(movies, this)
    }

    override fun getPopularMovies(page: Int) {
        menuSelected = 0
        if (NetworkUtils().isNetworkAvailable(requireContext())) {
            moviePresenter.getPopularMovies(page)
        } else {
            displayUIForInternetConnection(false)
        }
    }

    override fun showPopularMovies(movies: ArrayList<Movie>) {
        displayUIForInternetConnection(true)
        binding.rvMovieList.adapter = MovieListAdapter(movies, this)
    }

    override fun getUpcomingMovies() {
        menuSelected = 1
        if (NetworkUtils().isNetworkAvailable(requireContext())) {
            moviePresenter.getUpcomingMovies()
        } else {
            displayUIForInternetConnection(false)
        }
    }

    override fun showUpcomingMovies(movies: ArrayList<Movie>) {
        displayUIForInternetConnection(true)
        binding.rvMovieList.adapter = MovieListAdapter(movies, this)
    }

    override fun onClickItem(movieSelected: Movie) {
        val action =
            MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(movieSelected.id)
        findNavController().navigate(action)
    }

    companion object {
        private const val TAG = "MovieList"
    }
}