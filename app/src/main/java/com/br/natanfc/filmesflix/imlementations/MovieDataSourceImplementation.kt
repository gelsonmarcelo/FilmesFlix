package com.br.natanfc.filmesflix.imlementations

import android.util.Log
import com.br.natanfc.filmesflix.framework.api.MovieRestApiTask
import com.br.natanfc.filmesflix.data.MovieDataSource
import com.br.natanfc.filmesflix.domain.Movie

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask) : MovieDataSource {
    companion object {
        val TAG = javaClass::class.java.simpleName
    }

    private val movieList = arrayListOf<Movie>()

    //TODO 5 Aqui está implementada e aqui fara a request e obterá a resposta (Povoamento da lista)
    override fun getAllMoviesFromApi(): List<Movie> {
        //Chamada da API
        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieList
    }
}