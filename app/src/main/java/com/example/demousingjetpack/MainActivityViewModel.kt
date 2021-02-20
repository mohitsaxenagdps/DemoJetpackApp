package com.example.demousingjetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.NumberFormatException

class MainActivityViewModel(startingTotal: Double): ViewModel() {

    private var total = MutableLiveData(0.0)

    val totalData: LiveData<Double>
    get() = total

    val inputText = MutableLiveData("")

    init {
        total.value = startingTotal
    }

    fun setTotal(){
        try {
            total.value = total.value?.plus(inputText.value.toString().toDouble())
        } catch (e: NumberFormatException) {
        }
    }

}