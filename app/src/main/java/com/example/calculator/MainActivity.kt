package com.example.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var operation: String = "None"
    private var result: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Listeners for the Numbers
        binding.button0.setOnClickListener { numButtonClicked(binding.button0) }
        binding.button1.setOnClickListener { numButtonClicked(binding.button1) }
        binding.button2.setOnClickListener { numButtonClicked(binding.button2) }
        binding.button3.setOnClickListener { numButtonClicked(binding.button3) }
        binding.button4.setOnClickListener { numButtonClicked(binding.button4) }
        binding.button5.setOnClickListener { numButtonClicked(binding.button5) }
        binding.button6.setOnClickListener { numButtonClicked(binding.button6) }
        binding.button7.setOnClickListener { numButtonClicked(binding.button7) }
        binding.button8.setOnClickListener { numButtonClicked(binding.button8) }
        binding.button9.setOnClickListener { numButtonClicked(binding.button9) }

        // Listeners for the Operators
        binding.buttonAdd.setOnClickListener { operatorButtonClicked(binding.buttonAdd) }
        binding.buttonSub.setOnClickListener { operatorButtonClicked(binding.buttonSub) }
        binding.buttonMultiply.setOnClickListener { operatorButtonClicked(binding.buttonMultiply) }
        binding.buttonDivide.setOnClickListener { operatorButtonClicked(binding.buttonDivide) }

        // Listener for Equal Button
        binding.buttonEqual.setOnClickListener { equalButtonClicked() }

        // Listener for Clear Button
        binding.buttonClear.setOnClickListener { clearButtonClicked() }
    }

    private fun clearButtonClicked() {
        binding.calcValue.text = ""
    }

    private fun equalButtonClicked() {

        if(binding.calcValue.text.toString() != "") {
            when (operation) {
                "Add" -> { result = (result.toDouble() + binding.calcValue.text.toString().toDouble()).toString() }
                "Subtract" -> { result = (result.toDouble() - binding.calcValue.text.toString().toDouble()).toString() }
                "Multiply" -> { result = (result.toDouble() * binding.calcValue.text.toString().toDouble()).toString() }
                "Divide" -> {
                    if (binding.calcValue.text.toString().toDouble() != 0.toDouble()) {
                        result = (result.toDouble() / binding.calcValue.text.toString().toDouble()).toString()
                    }
                }
            }
            binding.calcValue.text = result
        }
    }

    private fun operatorButtonClicked(clickedButton: Button) {
        result = binding.calcValue.text.toString()

        when (clickedButton.text) {
            "+" -> { operation = "Add" }
            "-" -> { operation = "Subtract" }
            "*" -> { operation = "Multiply" }
            "/" -> { operation = "Divide"}
        }
        binding.calcValue.text = ""
    }

    private fun numButtonClicked(clickedButton: Button) {
        binding.calcValue.text = binding.calcValue.text.toString() + clickedButton.text.toString()
    }
}