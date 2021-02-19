package com.example.demousingjetpack

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import java.lang.NumberFormatException

class MainActivityViewModel(startingTotal: Double, editText: TextInputEditText): ViewModel() {

    private var total = MutableLiveData(0.0)
    @SuppressLint("StaticFieldLeak")
    private val myEditText: TextInputEditText
    val totalData: LiveData<Double>
    get() = total

    init {
        total.value = startingTotal
        myEditText = editText
    }

    fun setTotal(input: Double){
        total.value = total.value?.plus(input)
    }

    fun getEditTextValue(): Double {
        try {
            return myEditText.text.toString().toDouble()
        } catch (e: NumberFormatException){
            myEditText.error = "Number Required!"
            return 0.0
        }
    }

}