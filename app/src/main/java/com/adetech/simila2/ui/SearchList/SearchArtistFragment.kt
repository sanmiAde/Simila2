package com.adetech.simila2.ui.SearchList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adetech.simila2.R
import com.adetech.simila2.data.Model.ArtistList
import com.adetech.simila2.data.network.NetWorkState
import kotlinx.android.synthetic.main.fragment_search_artist.*
import kotlinx.android.synthetic.main.recyclerview.*

class SearchArtistFragment : Fragment() {


    private lateinit var searchViewModel: SearchArtistFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =

            inflater.inflate(R.layout.fragment_search_artist, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initViewModel()

        val adapter: SearchListAdapter = initRcylcerView()
        initNetworkStateViewModel()

        search.setOnClickListener { searchViewModel.getSimilarArtists("birdyjbhh").observe(this, Observer { artistList: ArtistList? -> adapter.setWords(artistList?.artist) }) }

    }

    private fun initNetworkStateViewModel() {

        searchViewModel.getNetworkState().observe(this, Observer { state: NetWorkState? ->
            when (state) {
                is NetWorkState.NotLoaded -> {
                    initLoadingUI(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE)
                }

                is NetWorkState.Loading -> {
                    initLoadingUI(View.INVISIBLE, View.VISIBLE, View.INVISIBLE)
                }

                is NetWorkState.Success -> {
                    initLoadingUI(View.VISIBLE, View.INVISIBLE, View.INVISIBLE)
                }
                is NetWorkState.Error -> {
                    initLoadingUI(View.INVISIBLE, View.INVISIBLE, View.VISIBLE)
                    textPlaceholder.text = state.errorMessage
                }

            }
        })
    }

    private fun initLoadingUI(recyclervieUi: Int, progressbarUI: Int, textPlaceHolderUi: Int) {

        recycler_view.visibility = recyclervieUi
        progressBar2.visibility = progressbarUI
        textPlaceholder.visibility = textPlaceHolderUi
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

    }

    private fun initViewModel() {

        searchViewModel = ViewModelProviders.of(this).get(SearchArtistFragmentViewModel::class.java)

    }


    private fun initRcylcerView(): SearchListAdapter {

        val context = activity!!.applicationContext

        val adapter: SearchListAdapter = SearchListAdapter(context)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = GridLayoutManager(context, 2)
        return adapter
    }

    companion object {
        fun newInstance(): SearchArtistFragment = SearchArtistFragment()
    }
}