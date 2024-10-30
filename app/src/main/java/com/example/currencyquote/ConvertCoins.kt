package com.example.currencyquote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyquote.databinding.ActivityConvertCoinsBinding
import com.google.android.material.snackbar.Snackbar

class ConvertCoins : AppCompatActivity() {

    private lateinit var binding: ActivityConvertCoinsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConvertCoinsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            Coins("EUR", R.drawable.ic_image1),
            Coins("USD", R.drawable.ic_image2),
            Coins("ARS", R.drawable.ic_image3),
            Coins("BOB", R.drawable.ic_image4),
            Coins("BRL", R.drawable.ic_image5),
            Coins("CLP", R.drawable.ic_image6),
            Coins("COP", R.drawable.ic_image7),
            Coins("PYG", R.drawable.ic_image8),
            Coins("PEN", R.drawable.ic_image9),
            Coins("UYU", R.drawable.ic_image10),
            Coins("VEN", R.drawable.ic_image11),
        )

        val adapterOne = CoinsListAdapter(this, items)
        binding.spinnerOne.adapter = adapterOne

        var spinnerOne = 0
        binding.spinnerOne.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    spinnerOne = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        val adapterTwo = CoinsListAdapter(this, items)
        binding.spinnerTwo.adapter = adapterTwo

        var spinnerTwo = 0
        binding.spinnerTwo.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    spinnerTwo = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        binding.btnConvert.setOnClickListener {
            val valueCoinStr: String = binding.edtValueCoin.text.toString()
            val titleResultStr = binding.tvTitleConversion
            val resultConvertStr = binding.tvCoins
            val coinOne: Int = spinnerOne
            val coinTwo: Int = spinnerTwo

            if (coinOne == coinTwo || valueCoinStr == "") {
                Snackbar.make(
                    binding.spinnerOne,
                    "select different currencies and fill in the value field",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {

                val valueCoin = valueCoinStr.toFloat()
                val titleResult: String = getString(R.string.text_result)

                //euro_dolar
                if (coinOne == 0 && coinTwo == 1) {
                    val usd = 1.08f
                    val convert = valueCoin * usd
                    val formatConvert = String.format("%.2f", convert)
                    titleResultStr.text = titleResult
                    resultConvertStr.text = "1€ = 1.08$"
                    binding.tvResult.text = "$ $formatConvert"

                }
                //dolar_euro
                if (coinOne == 1 && coinTwo == 0) {
                    val usd = 0.92f
                    val convert = valueCoin * usd
                    val formatConvert = String.format("%.2f", convert)
                    titleResultStr.text = titleResult
                    resultConvertStr.text = "1$ = 0.92€"
                    binding.tvResult.text = "€ $formatConvert"

                }
                //euro_real
                if (coinOne == 0 && coinTwo == 4) {
                    val usd = 6.16f
                    val convert = valueCoin * usd
                    titleResultStr.text = titleResult
                    val formatConvert = String.format("%.2f", convert)
                    resultConvertStr.text = "1€ = 6.16R$"
                    binding.tvResult.text = "R$ $formatConvert"

                }
                //real_euro
                if (coinOne == 4 && coinTwo == 0) {
                    val usd = 0.16f
                    val convert = valueCoin * usd
                    titleResultStr.text = titleResult
                    val formatConvert = String.format("%.2f", convert)
                    resultConvertStr.text = "1R$ = 0.16€"
                    binding.tvResult.text = "€ $formatConvert"

                }
                //real_dolar
                if (coinOne == 4 && coinTwo == 1) {
                    val usd = 0.17f
                    val convert = valueCoin * usd
                    titleResultStr.text = titleResult
                    val formatConvert = String.format("%.2f", convert)
                    resultConvertStr.text = "1R$ = 0.17$"
                    binding.tvResult.text = "$ $formatConvert"

                }
                //dolar_real
                if (coinOne == 1 && coinTwo == 4) {
                    val usd = 5.76f
                    val convert = valueCoin * usd
                    titleResultStr.text = titleResult
                    val formatConvert = String.format("%.2f", convert)
                    resultConvertStr.text = "1$ = 5.77R$"
                    binding.tvResult.text = "R$ $formatConvert"

                }
            }
        }
    }
}


