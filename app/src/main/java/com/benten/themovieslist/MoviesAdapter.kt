package com.benten.themovieslist

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benten.themovieslist.databinding.LayoutMovieItemBinding
import com.benten.themovieslist.models.MovieItem
import com.bumptech.glide.Glide

class MoviesAdapter: RecyclerView.Adapter<MoviesViewHolder>() {
    private val movieItem = mutableListOf<MovieItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =
            LayoutMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }





    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        val movieItem = movieItem[position]
        movieItem.apply {
            holder.binding.tvMovieName.text = originalTitle
            holder.binding.tvReleaseDate.text =
                holder.binding.root.context.getString(R.string.movie_release_date_text,releaseDate)
            holder.binding.tvRating.text = voteAverage.toString()
            holder.binding.tvAverageRating.text = popularity .toString()


            val posterUrl  =  "$IMAGE_PATH$posterPath"
            Glide.with(holder.binding.root.context).load(posterUrl).into(holder.binding.ivImagePoster)
        }
    }


    override fun getItemCount(): Int {
        return movieItem.size
    }

    companion object {
        const val IMAGE_PATH = "https://image.tmdb.org/t/p/w500"
    }
}



class MoviesViewHolder(val binding: LayoutMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}
