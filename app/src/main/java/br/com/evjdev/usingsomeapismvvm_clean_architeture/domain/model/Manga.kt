package br.com.evjdev.usingsomeapismvvm_clean_architeture.domain.model

import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("mal_id")
    var mID: Int? = null,
    @SerializedName("url")
    var mURL: String? = null,
    @SerializedName("image_url")
    var mIMG_URL: String? = null,
    @SerializedName("title")
    var mTitle: String? = null,
    @SerializedName("airing")
    var mAiring: Boolean? = null,
    @SerializedName("synopsis")
    var mSynopse: String? = null,
    @SerializedName("type")
    var mType: String? = null,
    @SerializedName("episodes")
    var mQtdEpisodes: Int? = null,
    @SerializedName("score")
    var mScore: Double? = null,
    @SerializedName("start_date")
    var mStartDate: String? = null,
    @SerializedName("end_date")
    var mEndDate: String? = null,
    @SerializedName("members")
    var mQtdMembers: Double? = null,
    @SerializedName("rated")
    var mRated: String? = null
)
