package br.com.evjdev.usingsomeapismvvm.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.evjdev.usingsomeapismvvm.data.api.BaseServiceIF
import br.com.evjdev.usingsomeapismvvm.data.model.Example
import br.com.evjdev.usingsomeapismvvm.data.repository.ExampleRepository
import br.com.evjdev.usingsomeapismvvm.utils.Constants
import retrofit2.Response

class ExampleViewModel(private val exampleRepository: ExampleRepository) : ViewModel(), BaseServiceIF {

    private val baseServiceIF: ExampleRepository = ExampleRepository(this)
    private val examplesListIn = MutableLiveData<List<Example>>()

    fun getExampleList(): MutableLiveData<List<Example>> {
        return examplesListIn
    }

    override fun <T : Any> onResultSuccess(responseIn: Response<T>, wsTagInt: Int) {

        when (wsTagInt) {

            Constants.GET_LIST_EXAMPLE -> {

            }
        }
    }

    override fun onResultFailure(msgIn: String, responseIn: Any?) {

    }
}