package com.adetech.simila2.data.network

import retrofit2.http.GET
import retrofit2.http.Query

private val apiKey: String = "f1206ed0cd61663480d26f89d76d622b"

internal interface LastFmDataService {


    @GET("/2.0/")
    fun getSimilarArtists(
            @Query("method") methodCall: String,
            @Query("artist") artistName: String,
            @Query("api_key") api_key: String,
            @Query("format") json: String
    )

    @GET("/2.0/")
    fun getArtist(
            @Query("method") methodCall: String,
            @Query("artist") artistName: String,
            @Query("api_key") api_key: String,
            @Query("format") json: String
    )
}