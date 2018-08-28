package com.adetech.simila2.ui.fragments

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.adetech.simila2.data.Model.ArtistList
import com.adetech.simila2.data.SimilarArtistRepository

class SearchArtistFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val similarArtistRepository: SimilarArtistRepository = SimilarArtistRepository(application)

    fun getSimilarArtists(artistName: String): LiveData<ArtistList> = similarArtistRepository.getSimilarArtist(artistName)

}