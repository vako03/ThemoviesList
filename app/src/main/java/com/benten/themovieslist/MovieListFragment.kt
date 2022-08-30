package com.benten.themovieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.benten.themovieslist.apis.RetrofitBuilder
import com.benten.themovieslist.databinding.LayoutMovieListFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListFragment : Fragment() {
    private var _binding: LayoutMovieListFragmentBinding? = null

    private val binding get() = _binding!!
    private val moviesAdapter = MoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutMovieListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(IO).launch {
            val popularsResponse = RetrofitBuilder.moviesApi.getPopularMovies(APY_KEY)
            withContext(Main){
                binding.progressBar.isVisible = false
            }

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
    companion object {
        const val APY_KEY=("843c612d1207fdec63f0e6a5fd426d68")
        }
}