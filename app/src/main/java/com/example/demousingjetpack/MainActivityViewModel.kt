package com.example.demousingjetpack

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private var total = 0.0

    fun setTotal(input: Double){
        total += input
    }

    fun getTotal() = total

}