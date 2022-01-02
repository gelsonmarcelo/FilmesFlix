package com.br.natanfc.filmesflix.data

import com.br.natanfc.filmesflix.domain.Movie

interface MovieDataSource {

    //TODO 4 Aqui é só a interface, não está implementada a função aqui
    fun getAllMoviesFromApi(): List<Movie>
}