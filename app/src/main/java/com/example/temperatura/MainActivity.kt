package com.example.temperatura

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextCelsius: EditText
    private lateinit var editTextFahrenheit: EditText
    private lateinit var editTextKelvin: EditText
    private lateinit var btnConvertir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCelsius = findViewById(R.id.editTextCelsius)
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit)
        editTextKelvin = findViewById(R.id.editTextKelvin)
        btnConvertir = findViewById(R.id.btnConvertir)

        btnConvertir.setOnClickListener {
            convertTemperatures()
        }
    }

    private fun convertTemperatures() {
        try {
            when {
                editTextCelsius.text.isNotEmpty() -> {
                    val celsius = editTextCelsius.text.toString().toDouble()
                    editTextFahrenheit.setText(String.format("%.2f", celsiusToFahrenheit(celsius)))
                    editTextKelvin.setText(String.format("%.2f", celsiusToKelvin(celsius)))
                }
                editTextFahrenheit.text.isNotEmpty() -> {
                    val fahrenheit = editTextFahrenheit.text.toString().toDouble()
                    editTextCelsius.setText(String.format("%.2f", fahrenheitToCelsius(fahrenheit)))
                    editTextKelvin.setText(String.format("%.2f", fahrenheitToKelvin(fahrenheit)))
                }
                editTextKelvin.text.isNotEmpty() -> {
                    val kelvin = editTextKelvin.text.toString().toDouble()
                    editTextCelsius.setText(String.format("%.2f", kelvinToCelsius(kelvin)))
                    editTextFahrenheit.setText(String.format("%.2f", kelvinToFahrenheit(kelvin)))
                }
            }
        } catch (e: NumberFormatException) {
            // Manejo de errores
        }
    }

    private fun celsiusToFahrenheit(celsius: Double) = (celsius * 9/5) + 32
    private fun celsiusToKelvin(celsius: Double) = celsius + 273.15
    private fun fahrenheitToCelsius(fahrenheit: Double) = (fahrenheit - 32) * 5/9
    private fun fahrenheitToKelvin(fahrenheit: Double) = (fahrenheit - 32) * 5/9 + 273.15
    private fun kelvinToCelsius(kelvin: Double) = kelvin - 273.15
    private fun kelvinToFahrenheit(kelvin: Double) = (kelvin - 273.15) * 9/5 + 32
}
