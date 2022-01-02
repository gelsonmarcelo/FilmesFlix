package com.br.natanfc.filmesflix.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    //TODO 3 O getAllMoviesFromDataSource chamará o getAllMoviesFromApi
    fun getAllMoviesFromDataSource() = movieDataSource.getAllMoviesFromApi()

}