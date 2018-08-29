package com.adetech.simila2.ui.SearchList

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.adetech.simila2.data.Model.ArtistList
import com.adetech.simila2.data.SimilarArtistRepository
import com.adetech.simila2.data.network.NetWorkState


class SearchArtistFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val similarArtistRepository: SimilarArtistRepository = SimilarArtistRepository(application)

    fun getSimilarArtists(artistName: String): LiveData<ArtistList> = similarArtistRepository.getSimilarArtist(artistName)

    fun getNetworkState(): LiveData<NetWorkState> = similarArtistRepository.getNetworkState()

}