package com.benten.themovieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.benten.themovieslist.apis.RetrofitBuilder
import com.benten.themovieslist.databinding.FragmentMovieDetailsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailsFragment:Fragment() {
    private var _binding:FragmentMovieDetailsBinding? = null
    private  val binding get() =_binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getInt(KEY_ID_PARA)
        CoroutineScope(IO).launch {
            val movieDetails=RetrofitBuilder.moviesApi.getMovieDetails(id,MovieListFragment.APY_KEY)
            withContext(Main){
                binding!!.tvMovieName.text=movieDetails.title

            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
    companion object {
        const val KEY_ID_PARA = "KEY_ID_PARA "
      fun  newInstance(id:Int):MovieDetailsFragment{
          return MovieDetailsFragment().apply {
              arguments = bundleOf(KEY_ID_PARA  to id)
          }
      }
    }
}