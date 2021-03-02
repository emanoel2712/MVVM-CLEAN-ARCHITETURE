package br.com.evjdev.usingsomeapismvvm.data.repository

import br.com.evjdev.usingsomeapismvvm.data.api.APIClient
import br.com.evjdev.usingsomeapismvvm.data.model.MangaResponse
import br.com.evjdev.usingsomeapismvvm.domain.model.Manga
import br.com.evjdev.usingsomeapismvvm.presenter.viewmodel.MangaViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MangaRepositoryImpl(private val service: APIClient) : MangaRepository {

    private var mangasListIn: List<Manga>? = listOf()

    override suspend fun getMangas(): List<Manga>? {

        val mCallback: Call<Manga> =
            this.service.clientAPI.getMangas(MangaViewModel.getMangaRandom())
        mCallback.enqueue(object : Callback<Manga> {
            override fun onResponse(call: Call<Manga>, response: Response<Manga>) {

                if (!response.isSuccessful) {
                    println("Falha na resposta do serviço!!")
                }

                response.body()?.let {
                    val mangaResponseIn: MangaResponse? = response.body() as MangaResponse?
                    mangasListIn = mangaResponseIn?.mListIn

                    println("RESPONSE SERVIÇO " + mangasListIn)
                }
            }

            override fun onFailure(call: Call<Manga>, t: Throwable) {

            }
        })

        return mangasListIn
    }
}

interface MangaRepository {
    suspend fun getMangas(): List<Manga>?
}