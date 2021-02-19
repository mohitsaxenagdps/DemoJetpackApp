package com.example.demousingjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.demousingjetpack.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.resultTxtView.text = viewModel.getTotal().toString()

        binding.apply {
            addBtn.setOnClickListener {
                try {
                    viewModel.setTotal(editTextLayout.editText?.text.toString().toDouble())
                    resultTxtView.text = viewModel.getTotal().toString()
                } catch (e: NumberFormatException) {
                    editText.error = "Number Required!"
                }
            }
        }
    }
}