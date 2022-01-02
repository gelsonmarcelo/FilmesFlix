package com.br.natanfc.filmesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.framework.api.MovieRestApiTask
import com.br.natanfc.filmesflix.data.MovieRepository
import com.br.natanfc.filmesflix.domain.Movie
import com.br.natanfc.filmesflix.imlementations.MovieDataSourceImplementation
import com.br.natanfc.filmesflix.usecase.MovieListUseCase

class MovieListViewModel : ViewModel() {

    companion object {
        val TAG = javaClass::class.java.simpleName
    }

    //Cada variável chama uma camada
    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MovieListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>() //Mutable significa mutável
    val moviesList: LiveData<List<Movie>> //O valor do LiveData não é mutável, mas modifica pois tem o valor do Mutable
        get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {

        Thread {
            try {
                //TODO 1 Pede para que o _moviesList observe o invoke, ou execução do useCase
                _moviesList.postValue(movieListUseCase.invoke())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()//Retorna o valor depois
//        _moviesList.value = listOfMovies //Como estamos trabalhando com dados mockados, pegamos value direto
//        //Se fossem dados que viriam posteriormente, usaria 'postValue'
    }
}