package com.example.demousingjetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Double): ViewModel() {

    private var total: MutableLiveData<Double> = MutableLiveData(0.0)

    val totalData: LiveData<Double>
    get() = total

    init {
        total.value = startingTotal
    }

    fun setTotal(input: Double){
        total.value = total.value?.plus(input)
    }

}