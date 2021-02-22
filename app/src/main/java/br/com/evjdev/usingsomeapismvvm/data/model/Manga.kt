package br.com.evjdev.usingsomeapismvvm.data.model

import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("nome")
    var nome: String = ""
)
