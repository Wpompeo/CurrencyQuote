package com.example.currencyquote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyquote.databinding.ActivityConvertCoinsBinding

class ConvertCoins : AppCompatActivity() {

    private lateinit var binding: ActivityConvertCoinsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConvertCoinsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.country_coins,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerOne.adapter = adapter

        var one = 0
        binding.spinnerOne.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    one = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        val adapterTwo = ArrayAdapter.createFromResource(
            this,
            R.array.country_coins,
            android.R.layout.simple_spinner_item
        )
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTwo.adapter = adapter

        var two = 1
        binding.spinnerTwo.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    two = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }
}