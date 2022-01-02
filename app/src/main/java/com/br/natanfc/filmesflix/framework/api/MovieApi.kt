package com.br.natanfc.filmesflix.framework.api

import com.br.natanfc.filmesflix.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    //https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList

    //Retrofit é uma aplicação que facilita a interação entre o app e o webService (APIs Rest)
    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies() : Call<List<Movie>> //Call faz a chamada a API
}