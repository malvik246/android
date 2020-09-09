package com.leudroid.mistplaychallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leudroid.mistplaychallenge.Adapaters.CategoryAdapter
import com.leudroid.mistplaychallenge.POJO.Category
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Getting Data from Json String and setting up the View
        getView()
    }

    private fun getView() {

        recyclerView = recyclerViewCategory

        //val jsonString = GetData.getJson();
        //val categoryList = object : TypeToken<List<Category>>() { }.type

        // using Gson parsing json string to category object
        val categoryList = Gson().fromJson<List<Category>>(GetData.getJson(),
            object : TypeToken<List<Category>>() { }.type)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CategoryAdapter(categoryList)
        }
    }
}