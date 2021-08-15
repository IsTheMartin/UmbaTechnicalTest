package me.ismartin.umbatechnicaltest.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.ismartin.umbatechnicaltest.databinding.MovieItemBinding
import me.ismartin.umbatechnicaltest.model.models.Movie

class MovieListAdapter(
  private val movieList: ArrayList<Movie>,
  private val movieListener: MovieListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = movieList[position]
        (holder as MovieViewHolder).bind(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MovieViewHolder(private val binding: MovieItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            with(binding.ivPoster) {
                val urlPoster = "https://image.tmdb.org/t/p/original${movie.posterPath}"
                Glide.with(binding.root)
                    .load(urlPoster)
                    .into(this)
            }

            with(binding.tvTitle) {
                text = movie.originalTitle
            }

            with(binding.tvReleaseDate) {
                text = movie.releaseDate
            }

            with(binding.tvRating) {
                text = movie.voteAverage.toString()
            }

            binding.root.setOnClickListener {
                movieListener.onClickItem(movie)
            }
        }
    }
}