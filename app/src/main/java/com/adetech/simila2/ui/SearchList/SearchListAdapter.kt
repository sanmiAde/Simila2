package com.adetech.simila2.ui.SearchList

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.adetech.simila2.R
import com.adetech.simila2.data.Model.Artist
import com.squareup.picasso.Picasso

class SearchListAdapter(val context: Context) : RecyclerView.Adapter<SearchListAdapter.SearchListViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var artists: List<Artist>? = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        val itemView: View = inflater.inflate(R.layout.artist_holder_item, parent, false)
        return SearchListViewHolder(itemView)
    }

    override fun getItemCount(): Int = artists?.size ?: 0

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        val currentartist: Artist? = artists?.get(position)

        holder.artistName.text = currentartist?.name
        holder.artistCorrelation.text = currentartist?.match
        val artistPictureUrl: String? = currentartist?.image?.get(4)?.text ?: ""
        if (artistPictureUrl!!.isNotEmpty()) {
            Picasso.with(context).load(artistPictureUrl).placeholder(R.drawable.placeholder).into(holder.artistPicture)
        }
    }

    internal fun setWords(artistList: List<Artist>?) {
        artists = artistList
        notifyDataSetChanged()
    }

    class SearchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artistName: TextView = itemView.findViewById(R.id.artist_name_txt)
        val artistPicture: ImageView = itemView.findViewById(R.id.artist_picture)
        val artistCorrelation: TextView = itemView.findViewById(R.id.artist_correlation)
    }
}