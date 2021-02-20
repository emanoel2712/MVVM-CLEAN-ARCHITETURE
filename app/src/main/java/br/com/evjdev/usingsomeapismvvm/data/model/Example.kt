package br.com.evjdev.usingsomeapismvvm.data.model

import com.google.gson.annotations.SerializedName

data class Example(
    @SerializedName("nome")
    var nome: String = ""
)
