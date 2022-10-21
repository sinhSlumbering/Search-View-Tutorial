package com.example.searchviewsexample

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.searchviewsexample.databinding.ActivityAutocompleteSearchBinding

class AutocompleteSearch : AppCompatActivity() {
    //declaring the binding
    private lateinit var binding: ActivityAutocompleteSearchBinding
    //declaring the array to be filtered
    val names = listOf("Bayern Munich", "Barcelona", "Dortmund", "Real Madrid", "Paris Saint Germain", "West Ham", "Roma", "Chelsea", "Wigan Athletic", "Charlton", "Saint Ettiene", "Liverpool")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initializing the binding
        binding = ActivityAutocompleteSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //declaring the array adapter for autocompletetextview
        var srcAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, names)
        //declaring the array adapter for listview
        var listAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, names)
        binding.autoCompleteTextView1.threshold = 1
        //providing the adapter to the searchview
        binding.autoCompleteTextView1.setAdapter(srcAdapter)
        //providing the adapter to the listview
        binding.listView2.adapter = listAdapter

        //filtering results on click of button
        binding.searchButton.setOnClickListener {
            val st = binding.autoCompleteTextView1.text.toString()
            if(names.contains(st)) {
                listAdapter.filter.filter(st)
            }
        }
    }
}