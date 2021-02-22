package br.com.evjdev.usingsomeapismvvm.data.api

import br.com.evjdev.usingsomeapismvvm.data.model.Manga
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIEndpoint {

    @GET("https://api.jikan.moe/v3/search/manga")
    fun getMangas(@Query("q") query: String): Call<Manga>

}