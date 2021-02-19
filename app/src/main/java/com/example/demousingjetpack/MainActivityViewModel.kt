package com.example.demousingjetpack

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Double): ViewModel() {

    private var total = 0.0

    init {
        total = startingTotal
    }

    fun setTotal(input: Double){
        total += input
    }

    fun getTotal() = total

}