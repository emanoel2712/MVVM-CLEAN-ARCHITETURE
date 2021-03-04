package br.com.evjdev.usingsomeapismvvm_clean_architeture.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    var clientAPI: APIResource

    init {

        val iLogging = HttpLoggingInterceptor()
        iLogging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val originalR = chain.request()
            val request = originalR.newBuilder()
            request.addHeader("Content-Type", "application/json")
            val requestF = request.build()
            chain.proceed(requestF)
        }

        httpClient.connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
        httpClient.readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
        httpClient.addInterceptor(iLogging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        this.clientAPI = retrofit.create(APIResource::class.java)
    }
}