package com.adetech.simila2.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adetech.simila2.R
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_about, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        web_view.loadUrl("file:///android_asset/about.html")

    }

    companion object {
        fun newInstance(): AboutFragment = AboutFragment()
    }

    interface Contract {
        fun finishAbout(): Unit
    }
}
