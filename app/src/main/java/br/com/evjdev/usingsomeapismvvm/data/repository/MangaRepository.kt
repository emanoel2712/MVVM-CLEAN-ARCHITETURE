package br.com.evjdev.usingsomeapismvvm.data.repository

import br.com.evjdev.usingsomeapismvvm.data.api.APIClient
import br.com.evjdev.usingsomeapismvvm.data.api.BaseServiceIF
import br.com.evjdev.usingsomeapismvvm.data.model.Manga
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MangaRepository(var baseServiceIF: BaseServiceIF) {

    lateinit var mAPIClient: APIClient

    fun getExampleList(wsTagInt: Int) {

        val mCallback: Call<Manga> = mAPIClient.clientAPI.listRepos("joao")
        mCallback.enqueue(object : Callback<Manga> {

            override fun onResponse(call: Call<Manga>, response: Response<Manga>) {
                if (!response.isSuccessful) {
//                    baseServiceIF.onResultFail(mainAPIClient.handlerAPIError(response.errorBody()))
                    println("Falha na resposta do serviço!!")
                }

                response.body()?.let {
                    baseServiceIF.onResultSuccess(Response.success(it), wsTagInt)
                }
            }

            override fun onFailure(call: Call<Manga>, t: Throwable) {

            }
        })
    }
}