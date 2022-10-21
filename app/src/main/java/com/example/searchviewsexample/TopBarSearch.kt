package com.example.searchviewsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.SearchView
import com.example.searchviewsexample.databinding.ActivityTopBarSearchBinding

class TopBarSearch : AppCompatActivity(), SearchView.OnQueryTextListener {
    private var names = listOf("Bayern Munich", "Barcelona", "Dortmund", "Real Madrid", "Paris Saint Germain", "West Ham", "Roma", "Chelsea", "Wigan Athletic", "Charlton", "Saint Ettiene", "Liverpool")
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var binding: ActivityTopBarSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_bar_search)
        binding = ActivityTopBarSearchBinding.inflate(layoutInflater)
        val rec: ListView = findViewById(R.id.topBarLstView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        rec.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.topmenu, menu)
        val search = menu?.findItem(R.id.search_top)
        val searchView = search?.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null){
            adapter.filter.filter(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText != null){
            adapter.filter.filter(newText)
        }
        return true
    }


}