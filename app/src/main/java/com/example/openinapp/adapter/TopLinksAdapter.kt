package com.example.openinapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.openinapp.OpenInModel.TopLinks
import com.example.openinapp.R


class TopLinksAdapter(data: TopLinks) : RecyclerView.Adapter<TopLinksAdapter.ViewHolder>()  {
    var links =  data
    inner class ViewHolder(itemVIew: View):RecyclerView.ViewHolder(itemVIew) {
        var img= itemVIew.findViewById<ImageView>(R.id.img_view)
        var title= itemVIew.findViewById<TextView>(R.id.title)
        var context=itemVIew.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_links_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return links.data.top_links.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text  = links.data.top_links[position].title
    }
}