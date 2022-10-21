package com.example.searchviewsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.searchviewsexample.databinding.ActivitySearchViewExampleBinding

class SearchViewExample : AppCompatActivity() {
    //declaring the binding
    private lateinit var binding: ActivitySearchViewExampleBinding
    //declaring the array to be filtered
    val names = arrayOf("noki", "noki2", "niloy", "sinha", "not Sinha", "Srilanka")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initializing the binding
        binding = ActivitySearchViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //declaring the array adapter for listview
        val arrAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        //providing the adapter to the listview
        binding.listView1.adapter = arrAdapter
        //filtering using the searchview
        binding.searchinmainbod.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchinmainbod.clearFocus()
                if(query!=null){
                    if(names.contains(query)){
                        arrAdapter.filter.filter(query)
                    }
                }
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if(names.contains(query)){
                    arrAdapter.filter.filter(query)
                }
                return false
            }
        })
    }
}