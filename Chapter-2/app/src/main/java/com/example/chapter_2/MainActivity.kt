package com.example.chapter_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import com.example.chapter_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mes: String = "Tip: $"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            var costService =  binding.etCost.text.toString().toDouble()
            var radioButtonId: Int = binding.rgServiceCategory.checkedRadioButtonId

            var percent:Double = when(radioButtonId){
                binding.rbAmazing.id -> 20.0
                binding.rbGood.id -> 18.0
                binding.rbOk.id -> 15.0
                else -> 0.0
            }

            var result:Double = costService*percent/100
            if(binding.switch1.isChecked){
                binding.tvResult.text = mes + result.toInt().toString()
            }else{
                binding.tvResult.text = mes + result.toString()
            }

        }


    }
}
