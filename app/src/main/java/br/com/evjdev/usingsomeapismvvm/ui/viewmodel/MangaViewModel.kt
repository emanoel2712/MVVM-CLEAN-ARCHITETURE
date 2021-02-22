package br.com.evjdev.usingsomeapismvvm.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.evjdev.usingsomeapismvvm.data.repository.BaseServiceIF
import br.com.evjdev.usingsomeapismvvm.data.model.Manga
import br.com.evjdev.usingsomeapismvvm.data.model.response.MangaResponse
import br.com.evjdev.usingsomeapismvvm.data.repository.MangaRepository
import br.com.evjdev.usingsomeapismvvm.utils.Values
import retrofit2.Response

class MangaViewModel() : ViewModel(), BaseServiceIF {

    companion object {
        var sharedInstance: MangaViewModel = MangaViewModel()
    }

    private val mMangaRepository: MangaRepository = MangaRepository(this)
    private val mMangaList = MutableLiveData<List<Manga>>()

    //MARK: Public Methods

    fun getMangaRandom(): String {
        val mangaListIn: List<String> = listOf(
            "Death Note", "Fullmetal Alchemist",
            "Ataque dos Titãs",
            "Sakura Card Captors",
            "Dr. Stone",
            "The Seven Deadly Sins",
            "Cavaleiros do Zodíaco",
            "Naruto Gold",
            "Ghost in the Shell",
            "Dragon Ball",
            "One Piece",
            "Hunter x Hunter",
            "Vinland Saga",
            "One-Punch Man",
            "Boku No Hero Academia")

        return mangaListIn.random()
    }

    fun getMangaList(): MutableLiveData<List<Manga>> {
        return mMangaList
    }


    //MARK: API Methods

    fun getMangaListWS() {
        this.mMangaRepository.getMangas(Values.GET_LIST_MANGA_WS)
    }

    //MARK: Base Service Interface Methods

    override fun <T : Any> onResultSuccess(responseIn: Response<T>, wsTagInt: Int) {

        when (wsTagInt) {

            Values.GET_LIST_MANGA_WS -> {
                val mMangaResponse: MangaResponse? = responseIn.body() as MangaResponse?
                mMangaResponse?.mListIn?.let {
                    this.mMangaList.postValue(it)
                }
            }
        }
    }

    override fun onResultFailure(msgIn: String, responseIn: Any?) {

    }
}