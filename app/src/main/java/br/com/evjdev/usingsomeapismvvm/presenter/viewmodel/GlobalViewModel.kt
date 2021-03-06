package br.com.evjdev.usingsomeapismvvm.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import br.com.evjdev.usingsomeapismvvm.R
import br.com.evjdev.usingsomeapismvvm.domain.model.Card

class GlobalViewModel : ViewModel() {

//    var mCardSelected: MutableLiveData<Card> = MutableLiveData(Card())

    companion object {
        var sharedInstance: GlobalViewModel = GlobalViewModel()
    }

    val navHostFragment = NavHostFragment.create(R.navigation.nav_graph)
    var mCardList: List<Card> = listOf(Card(1, "MANGÁ"))
    var mCardSelected: Card = Card()

}