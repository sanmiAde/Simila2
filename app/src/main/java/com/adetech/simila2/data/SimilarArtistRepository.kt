package com.adetech.simila2.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.adetech.simila2.data.Model.ArtistList
import com.adetech.simila2.data.Model.SimilarArtist
import com.adetech.simila2.data.network.LastFmDataService
import com.adetech.simila2.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


internal class SimilarArtistRepository(val application: Application) {


    fun getSimilarArtist(artistName: String): LiveData<ArtistList> {

        val service: LastFmDataService = RetrofitInstance.initRetrofitInstance()
        val call: Call<SimilarArtist> = service.getSimilarArtists(artistName = artistName)
        val similarArtistLiveData: MutableLiveData<ArtistList> = MutableLiveData()

        networkCall(call, similarArtistLiveData)

        return similarArtistLiveData

    }

    private fun networkCall(call: Call<SimilarArtist>, similarArtistLiveData: MutableLiveData<ArtistList>) {
        call.enqueue(object : Callback<SimilarArtist> {
            override fun onFailure(call: Call<SimilarArtist>?, t: Throwable?) {
                Log.e(SimilarArtistRepository::class.simpleName, t?.message)
            }

            override fun onResponse(call: Call<SimilarArtist>?, response: Response<SimilarArtist>?) {
                when {
                    response?.code() == 200 -> when {
                        response.body()?.similarartists != null -> {
                            similarArtistLiveData.value = response.body()!!.similarartists
                        }
                    }
                }
            }
        })
    }
}