package me.ismartin.umbatechnicaltest.view

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import me.ismartin.umbatechnicaltest.R
import me.ismartin.umbatechnicaltest.databinding.FragmentMovieDetailBinding
import me.ismartin.umbatechnicaltest.model.models.MovieDetail
import me.ismartin.umbatechnicaltest.presenter.MovieDetailPresenter
import me.ismartin.umbatechnicaltest.presenter.MovieDetailPresenterImpl

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail), MovieDetailsView {

    private lateinit var binding: FragmentMovieDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()
    private lateinit var movieDetailPresenter: MovieDetailPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(layoutInflater, container, false)
        movieDetailPresenter = MovieDetailPresenterImpl(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.tbDetail) {
            setNavigationIcon(R.drawable.ic_action_back_arrow)
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }

        val idMovie = args.idMovie
        getMovieDetails(idMovie)
    }

    private fun updateViews(movieDetails: MovieDetail) {
        binding.tvTitle.text = movieDetails.originalTitle
        binding.tvReleaseDate.text = "${movieDetails.releaseDate} | ${movieDetails.voteAverage}"
        binding.tvOverview.text = movieDetails.overview
        binding.tvRuntime.text = "${movieDetails.runtime} minutes"
        val urlPoster = "https://image.tmdb.org/t/p/original${movieDetails.posterPath}"
        Glide.with(binding.root)
            .load(urlPoster)
            .into(binding.ivPoster)

        movieDetails.genres.forEach {
            val chip = Chip(requireContext()).apply {
                setText(it.name)
                chipBackgroundColor = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }
            binding.cgGenres.addView(chip)
        }
    }

    override fun getMovieDetails(movieId: Int) {
        movieDetailPresenter.getMovieDetails(movieId)
    }

    override fun showMovieDetails(movieDetails: MovieDetail) {
        updateViews(movieDetails)
    }

    companion object {
        private const val TAG = "MovieDetail"
    }
}