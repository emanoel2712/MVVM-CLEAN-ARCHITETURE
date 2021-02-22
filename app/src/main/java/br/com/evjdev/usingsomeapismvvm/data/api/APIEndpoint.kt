package br.com.evjdev.usingsomeapismvvm.data.api

import br.com.evjdev.usingsomeapismvvm.data.model.Manga
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIEndpoint {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<Manga>



}