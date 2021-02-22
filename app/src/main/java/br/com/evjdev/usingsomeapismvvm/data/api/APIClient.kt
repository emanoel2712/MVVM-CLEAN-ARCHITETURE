package br.com.evjdev.usingsomeapismvvm.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIClient {

    var clientAPI: APIEndpoint

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("asdsadsad")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        this.clientAPI = retrofit.create(APIEndpoint::class.java)
    }

}