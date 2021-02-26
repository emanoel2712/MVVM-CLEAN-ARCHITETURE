package br.com.evjdev.usingsomeapismvvm.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIClient {

    var clientAPI: APIResource

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        this.clientAPI = retrofit.create(APIResource::class.java)
    }

}