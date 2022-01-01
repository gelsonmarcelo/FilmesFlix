package com.br.natanfc.filmesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.model.Movie

class MovieListViewModel : ViewModel() {

    private val listOfMovies = arrayListOf(
        Movie(
            0,
            "Titaic",
            null,
            null,
            null
        ),
        Movie(
            1,
            "Central do Brasil",
            null,
            null,
            null
        )
    )

    private var _moviesList = MutableLiveData<List<Movie>>() //Mutable significa mutável
    val moviesList: LiveData<List<Movie>> //O valor do LiveData não é mutável, mas modifica pois tem o valor do Mutable
    get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        _moviesList.value = listOfMovies //Como estamos trabalhando com dados mockados, pegamos value direto
        //Se fossem dados que viriam posteriormente, usaria 'postValue'
    }
}