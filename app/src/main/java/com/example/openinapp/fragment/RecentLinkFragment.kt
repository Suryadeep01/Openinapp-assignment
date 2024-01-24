package com.example.openinapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.openinapp.HomeViewModel.HomeViewModel
import com.example.openinapp.OpenInModel.TopLinks
import com.example.openinapp.R
import com.example.openinapp.adapter.TopLinksAdapter


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RecentLinkFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: HomeViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_recent_link, container, false)
        recyclerView = view.findViewById(R.id.recent_view_recycler)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getApiLink()
        viewModel.topLinks.observe(viewLifecycleOwner){
            recyclerView(it)
        }
        return  view
    }
    private fun recyclerView(data: TopLinks) {
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val adapter= TopLinksAdapter(data)
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecentLinkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}