package com.leudroid.mistplaychallenge.Adapaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leudroid.mistplaychallenge.POJO.Category
import com.leudroid.mistplaychallenge.R
import kotlinx.android.synthetic.main.category.view.*

class CategoryAdapter(private val categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.category,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList[position]
        holder.textView.text = category.list_title

        //Please Check this error.
        val gamesLayoutManager = LinearLayoutManager(holder.recyclerView.context, LinearLayout.HORIZONTAL, false)

        //Please check this line also
        gamesLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = gamesLayoutManager
            adapter = GamesAdapter(category.games)
            setRecycledViewPool(viewPool)
        }

    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.recyclerViewGames
        val textView:TextView = itemView.textViewCategory
    }
}
