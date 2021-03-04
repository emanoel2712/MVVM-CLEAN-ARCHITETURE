package br.com.evjdev.usingsomeapismvvm.data.repository

import br.com.evjdev.usingsomeapismvvm.data.api.APIClient
import br.com.evjdev.usingsomeapismvvm.data.model.MangaResponse
import br.com.evjdev.usingsomeapismvvm.domain.model.Manga
import br.com.evjdev.usingsomeapismvvm.presenter.viewmodel.MangaViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MangaRepositoryImpl(private val service: APIClient) : MangaRepository {

    lateinit var mangasListIn: List<Manga>

    override suspend fun getMangas(): List<Manga> {
        val mCallback: Call<MangaResponse> =
            this.service.clientAPI.getMangas(MangaViewModel.sharedInstance.getMangaRandom())

        mCallback.enqueue(object : Callback<MangaResponse> {
            override fun onResponse(call: Call<MangaResponse>, response: Response<MangaResponse>) {

                if (!response.isSuccessful) {
                    println("Falha na resposta do serviço!!")
                }

                response.body()?.let {
                    val mangaResponseIn: MangaResponse = it
                    mangasListIn = mangaResponseIn.mListIn
                    println("RESPONSE SERVIÇO " + mangasListIn)
                }
            }

            override fun onFailure(call: Call<MangaResponse>, t: Throwable) {

            }
        })

        return mangasListIn
    }
}

interface MangaRepository {
    suspend fun getMangas(): List<Manga>
}