package br.com.evjdev.usingsomeapismvvm.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.evjdev.usingsomeapismvvm.domain.model.GetMangasUseCase
import br.com.evjdev.usingsomeapismvvm.domain.model.Manga
import kotlinx.coroutines.launch

class MangaViewModel(private val getMangasUseCase: GetMangasUseCase? = null) : ViewModel() {

    companion object {
        var sharedInstance: MangaViewModel = MangaViewModel()
    }

    private val mMangaList = MutableLiveData<List<Manga>>()
    val mangas = mMangaList as LiveData<List<Manga>>

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
            "Boku No Hero Academia"
        )

        return mangaListIn.random()
    }

    //MARK: API Methods

    fun getMangas() {
        viewModelScope.launch {
            mMangaList.value = getMangasUseCase?.let {
                it()
            }

            println("LIST MANGA IN: ${mMangaList.toString()}")
        }
    }
}