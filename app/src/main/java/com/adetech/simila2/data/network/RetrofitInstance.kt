package com.adetech.simila2.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL: String = "http://ws.audioscrobbler.com/"

    internal fun initRetrofitInstance(): LastFmDataService {

        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit.create(LastFmDataService::class.java)

    }
}