package com.br.natanfc.filmesflix.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.br.natanfc.filmesflix.R
import com.br.natanfc.filmesflix.model.Movie
import com.br.natanfc.filmesflix.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel =
            ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java) //Instancia do ViewModel
        movieListViewModel.init() //Chamar o método init

        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver() {
        //Aqui vamos observar o nosso LiveData
        movieListViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }

        })
    }

    private fun populateList(list: List<Movie>) {
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        progress_bar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}