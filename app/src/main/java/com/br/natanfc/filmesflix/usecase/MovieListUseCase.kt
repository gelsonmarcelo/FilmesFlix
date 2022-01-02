package com.br.natanfc.filmesflix.usecase

import com.br.natanfc.filmesflix.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {

    //TODO 2 Chama o getAllMoviesFromDataSource
    operator fun invoke() = movieRepository.getAllMoviesFromDataSource() //Vai executar a chamada para o método getAll...
    //E esse irá pegar a lista de todos os filmes
}