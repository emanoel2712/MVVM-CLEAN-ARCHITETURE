package br.com.evjdev.usingsomeapismvvm.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.evjdev.usingsomeapismvvm.data.api.BaseServiceIF
import br.com.evjdev.usingsomeapismvvm.data.model.Manga
import br.com.evjdev.usingsomeapismvvm.data.model.response.MangaResponse
import br.com.evjdev.usingsomeapismvvm.data.repository.MangaRepository
import br.com.evjdev.usingsomeapismvvm.utils.Values
import retrofit2.Response

class MangaViewModel(private val mangaRepository: MangaRepository) : ViewModel(),
    BaseServiceIF {

    private val mMangaRepository: MangaRepository = MangaRepository(this)
    private val examplesListIn = MutableLiveData<List<Manga>>()

    fun getExampleList(): MutableLiveData<List<Manga>> {
        return examplesListIn
    }

    fun getExampleListWS() {
        this.mMangaRepository.getExampleList(Values.GET_LIST_MANGA_WS)
    }

    override fun <T : Any> onResultSuccess(responseIn: Response<T>, wsTagInt: Int) {

        when (wsTagInt) {

            Values.GET_LIST_MANGA_WS -> {
                var mMangaResponse: MangaResponse? = responseIn.body() as MangaResponse?
                mMangaResponse.let {

                }
            }
        }
    }

    override fun onResultFailure(msgIn: String, responseIn: Any?) {

    }
}