package com.example.demousingjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demousingjetpack.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(10.5)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        viewModel.totalData.observe(this, Observer {
            binding.resultTxtView.text = it.toString()
        })

        binding.apply {
            addBtn.setOnClickListener {
                try {
                    viewModel.setTotal(editTextLayout.editText?.text.toString().toDouble())
                } catch (e: NumberFormatException) {
                    editText.error = "Number Required!"
                }
            }
        }
    }
}