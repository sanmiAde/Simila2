package com.adetech.simila2.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.adetech.simila2.R
import com.adetech.simila2.ui.fragments.AboutFragment
import com.adetech.simila2.ui.fragments.SearchArtistFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
                replaceFragment(SearchArtistFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_database -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_about -> {
                replaceFragment(AboutFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment(SearchArtistFragment.newInstance()) //change implementation

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


    private fun initFragment(fragment: Fragment): Unit {

        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
        }

    }

    private fun replaceFragment(fragment: Fragment): Unit {

        if (supportFragmentManager.findFragmentById(R.id.fragment_container)::class.simpleName == fragment::class.simpleName) {
            Toast.makeText(this, fragment::class.java.simpleName, Toast.LENGTH_SHORT).show()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        }


    }
}
