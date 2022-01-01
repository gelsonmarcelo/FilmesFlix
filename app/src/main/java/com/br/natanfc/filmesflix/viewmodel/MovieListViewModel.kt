package com.br.natanfc.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.api.MovieRestApiTask
import com.br.natanfc.filmesflix.model.Movie
import com.br.natanfc.filmesflix.repository.MovieRepository
import java.lang.Exception

class MovieListViewModel : ViewModel() {

    companion object {
        val TAG = javaClass::class.java.simpleName
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var _moviesList = MutableLiveData<List<Movie>>() //Mutable significa mutável
    val moviesList: LiveData<List<Movie>> //O valor do LiveData não é mutável, mas modifica pois tem o valor do Mutable
        get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {

        Thread {
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()//Retorna o valor depois
//        _moviesList.value = listOfMovies //Como estamos trabalhando com dados mockados, pegamos value direto
//        //Se fossem dados que viriam posteriormente, usaria 'postValue'
    }
}