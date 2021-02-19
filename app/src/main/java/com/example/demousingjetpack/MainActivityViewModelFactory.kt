package com.example.demousingjetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import java.lang.IllegalArgumentException

class MainActivityViewModelFactory(private val startingTotal: Double, private val editText: TextInputEditText): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(startingTotal, editText) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}