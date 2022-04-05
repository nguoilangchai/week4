package com.example.baitaptuan3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baitaptuan3.R.layout.activity_show_menu
import com.example.baitaptuan3.databinding.ActivityShowMenuBinding

class ShowMenu : AppCompatActivity() {
    lateinit var binding:ActivityShowMenuBinding
    lateinit var viewMode:MainVM
    lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, activity_show_menu)
        viewMode = ViewModelProvider(this).get(MainVM::class.java)


        adapter = RestaurantAdapter()
        val lm = LinearLayoutManager(this)

        binding.rvRestaurant.layoutManager = lm
        binding.rvRestaurant.adapter = adapter
        registerData()
    }
    override fun onStart() {
        super.onStart()
        viewMode.loadData()
    }
    private fun registerData(){
        viewMode.listOfData.observe(this){
            adapter.submitList(it)
        }

    }
}