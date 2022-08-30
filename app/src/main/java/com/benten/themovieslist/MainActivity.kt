package com.benten.themovieslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benten.themovieslist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContent,MovieListFragment())
            addToBackStack("")
            commit()
        }
    }
}