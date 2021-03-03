package br.com.evjdev.usingsomeapismvvm.data.model

import br.com.evjdev.usingsomeapismvvm.domain.model.Manga
import com.google.gson.annotations.SerializedName

data class MangaResponse(
    @SerializedName("request_hash")
    var mRequestHash: String? = null,
    @SerializedName("request_cached")
    var mRequestCached: Boolean? = null,
    @SerializedName("request_cache_expiry")
    var mRequestCacheExpiry: String? = null,
    @SerializedName("results")
    var mListIn: List<Manga>? = listOf(),
)
