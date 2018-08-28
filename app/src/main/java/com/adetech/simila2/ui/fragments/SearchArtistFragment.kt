package com.adetech.simila2.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.adetech.simila2.R
import com.adetech.simila2.data.Model.ArtistList
import kotlinx.android.synthetic.main.fragment_search_artist.*

class SearchArtistFragment : Fragment() {

    private lateinit var searchButton: Button

    private lateinit var searchViewModel: SearchArtistFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_search_artist, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search.setOnClickListener { searchViewModel.getSimilarArtists("birdy").observe(this, Observer { artistList: ArtistList? -> textView.append(artistList.toString()) }) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()

    }

    private fun initViewModel() {

        searchViewModel = ViewModelProviders.of(this).get(SearchArtistFragmentViewModel::class.java)

    }

    companion object {
        fun newInstance(): SearchArtistFragment = SearchArtistFragment()
    }
}