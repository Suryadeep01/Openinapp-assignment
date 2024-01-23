package com.example.openinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.openinapp.HomeViewModel.HomeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getApiLink()
        viewModel.topLinks.observe(this){
            findViewById<TextView>(R.id.hello).text = it.top_links[0].title

        }
    }
}