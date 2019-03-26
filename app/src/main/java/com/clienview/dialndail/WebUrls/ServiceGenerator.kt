package com.clienview.dialndail.WebUrls

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private val httpClient = OkHttpClient.Builder()

    fun <S> createService(serviceClass: Class<S>, baseUrl: String): S {

        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        return builder.create(serviceClass)
    }
}