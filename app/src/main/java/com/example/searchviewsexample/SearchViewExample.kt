package com.example.searchviewsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.searchviewsexample.databinding.ActivitySearchViewExampleBinding

class SearchViewExample : AppCompatActivity() {
    //declaring the binding
    private lateinit var binding: ActivitySearchViewExampleBinding
    val names = listOf("bayern", "barcelona", "dortmund", "madrid", "roma", "chelsea", "charlton", "liverpool")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        binding.listView1.adapter = arrAdapter

        binding.searchinmainbod.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.searchinmainbod.clearFocus()
                if(names.contains(p0)){
                    arrAdapter.filter.filter(p0)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if(names.contains(p0)){
                    arrAdapter.filter.filter(p0)
                }
                return true
            }
        })


    }
}