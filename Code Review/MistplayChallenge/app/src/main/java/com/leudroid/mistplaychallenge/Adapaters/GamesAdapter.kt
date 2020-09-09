package com.leudroid.mistplaychallenge.Adapaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leudroid.mistplaychallenge.POJO.Game
import com.leudroid.mistplaychallenge.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.game.view.*

class GamesAdapter(private var gamesList: List<Game>) :
    RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v =  LayoutInflater.from(parent.context)
            .inflate(R.layout.game, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        val child = gamesList[position]
        Picasso.get().load(child.img).into(holder.imageView)
        holder.textView.text = child.title

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textView : TextView = itemView.textViewTitle
        val imageView: ImageView = itemView.imageViewGame

    }
}