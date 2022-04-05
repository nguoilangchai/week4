package com.example.baitaptuan3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baitaptuan3.model.Restaurant

class MainVM : ViewModel() {
    private var _listOfData : MutableLiveData<List<Restaurant>> = MutableLiveData()
    val listOfData : LiveData<List<Restaurant>>
        get() = _listOfData

    fun loadData(){
        val data = DataRestaurant.getDataSet()
        _listOfData.postValue(data)
    }
}