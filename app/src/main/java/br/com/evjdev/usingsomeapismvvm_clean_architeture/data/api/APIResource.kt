package br.com.evjdev.usingsomeapismvvm_clean_architeture.data.api

import br.com.evjdev.usingsomeapismvvm_clean_architeture.data.model.MangaResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIResource {

    @GET("https://api.jikan.moe/v3/search/manga")
    fun getMangas(@Query("q") query: String): Call<MangaResponse>

}