package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operation: String = "None"
    var result: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // All the Buttons
        val button1: Button = findViewById(R.id.button_1)
        val button2: Button = findViewById(R.id.button_2)
        val button3: Button = findViewById(R.id.button_3)
        val button4: Button = findViewById(R.id.button_4)
        val button5: Button = findViewById(R.id.button_5)
        val button6: Button = findViewById(R.id.button_6)
        val button7: Button = findViewById(R.id.button_7)
        val button8: Button = findViewById(R.id.button_8)
        val button9: Button = findViewById(R.id.button_9)
        val button0: Button = findViewById(R.id.button_0)
        val buttonAdd: Button = findViewById(R.id.button_add)
        val buttonSubtract: Button = findViewById(R.id.button_sub)
        val buttonMultiply: Button = findViewById(R.id.button_multiply)
        val buttonDivide: Button = findViewById(R.id.button_divide)
        val buttonEqual: Button = findViewById(R.id.button_equal)
        val buttonClear: Button = findViewById(R.id.button_clear)

        // Listeners for the Numbers
        button0.setOnClickListener { numButtonClicked(button0) }
        button1.setOnClickListener { numButtonClicked(button1) }
        button2.setOnClickListener { numButtonClicked(button2) }
        button3.setOnClickListener { numButtonClicked(button3) }
        button4.setOnClickListener { numButtonClicked(button4) }
        button5.setOnClickListener { numButtonClicked(button5) }
        button6.setOnClickListener { numButtonClicked(button6) }
        button7.setOnClickListener { numButtonClicked(button7) }
        button8.setOnClickListener { numButtonClicked(button8) }
        button9.setOnClickListener { numButtonClicked(button9) }

        // Listeners for the Operators
        buttonAdd.setOnClickListener { operatorButtonClicked(buttonAdd) }
        buttonSubtract.setOnClickListener { operatorButtonClicked(buttonSubtract) }
        buttonMultiply.setOnClickListener { operatorButtonClicked(buttonMultiply) }
        buttonDivide.setOnClickListener { operatorButtonClicked(buttonDivide) }

        // Listener for Equal Button
        buttonEqual.setOnClickListener { equalButtonClicked(buttonAdd) }

        // Listener for Clear Button
        buttonClear.setOnClickListener { clearButtonClicked(buttonClear) }
    }

    private fun clearButtonClicked(clickedButton: Button) {
        var calcValue: TextView = findViewById(R.id.calc_value)
        calcValue.text = ""
    }

    private fun equalButtonClicked(clickedButton: Button) {
        var calcValue: TextView = findViewById(R.id.calc_value)
        when(operation) {
            "Add" -> { result = (result.toInt() + calcValue.text.toString().toInt()).toString() }
            "Subtract" -> { result = (result.toInt() - calcValue.text.toString().toInt()).toString() }
            "Multiply" -> { result = (result.toInt() * calcValue.text.toString().toInt()).toString() }
            "Divide" -> { result = (result.toInt() / calcValue.text.toString().toInt()).toString() }
        }
        calcValue.text = result
    }

    private fun operatorButtonClicked(clickedButton: Button) {
        var calcView: TextView = findViewById(R.id.calc_value)
        result = calcView.text.toString()

        when (clickedButton.text) {
            "+" -> { operation = "Add" }
            "-" -> { operation = "Subtract" }
            "*" -> { operation = "Multiply" }
            "/" -> { operation = "Divide"}
        }
        calcView.text = ""
    }

    private fun numButtonClicked(clickedButton: Button) {
        var calcValue: TextView = findViewById(R.id.calc_value)
        calcValue.text = calcValue.text.toString() + clickedButton.text.toString()
    }
}