package com.br.natanfc.filmesflix.framework.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApiTask {

    //Companion Object: permite criar constante no Kotlin
    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com"
    }

    /**
     * Provedor de filmes
     */
    private fun movieProvider():Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) //Android converte o Json para conseguir utilizar (bibliotexa gson no gradle)
        .build()

    fun retrofitApi(): MovieApi = movieProvider().create(MovieApi::class.java)
}