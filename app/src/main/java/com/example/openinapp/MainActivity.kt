package com.example.openinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.openinapp.HomeViewModel.HomeViewModel
import com.example.openinapp.adapter.ViewPagerAdapter
import com.example.openinapp.fragment.RecentLinkFragment
import com.example.openinapp.fragment.TopLinkFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getApiLink()
        viewModel.topLinks.observe(this){
            //findViewById<TextView>(R.id.hello).text = it.top_location
        }
        // set the references of the declared objects above
        pager = findViewById(R.id.viewPager)
        tab = findViewById<TabLayout>(R.id.tabs)


        // Initializing the ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(TopLinkFragment(), "TopLink")
        adapter.addFragment(RecentLinkFragment(), "RecentLink")

        // Adding the Adapter to the ViewPager
        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)

    }
}