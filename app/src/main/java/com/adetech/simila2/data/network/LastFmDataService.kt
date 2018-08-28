package com.adetech.simila2.data.network

import com.adetech.simila2.data.Model.SimilarArtist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY: String = "f1206ed0cd61663480d26f89d76d622b"
private const val METHOD_CALL = "artist.getsimilar"
private const val JSON = "json"

internal interface LastFmDataService {


    @GET("/2.0/")
    fun getSimilarArtists(
            @Query("method") methodCall: String = METHOD_CALL,
            @Query("artist") artistName: String,
            @Query("api_key") api_key: String = API_KEY,
            @Query("format") json: String = JSON
    ): Call<SimilarArtist>

    @GET("/2.0/")
    fun getArtist(
            @Query("method") methodCall: String,
            @Query("artist") artistName: String,
            @Query("api_key") api_key: String,
            @Query("format") json: String
    )
}