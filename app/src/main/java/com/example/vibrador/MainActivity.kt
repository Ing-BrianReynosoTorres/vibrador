package com.example.vibrador

import android.os.Bundle
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var vibrationCount = 0
    private var totalVibrationTime = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.vibrateButton)
        val textView: TextView = findViewById(R.id.vibrationInfo)

        button.setOnClickListener {
            val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
            val vibrationTime = 1000 // Duración en milisegundos (1s)

            vibrator.vibrate(vibrationTime.toLong())

            // Actualizar contador y tiempo total
            vibrationCount++
            totalVibrationTime += vibrationTime / 100 // Convertir a segundos

            // Mostrar mensaje en TextView
            textView.text = "Vibraciones: $vibrationCount | Tiempo total: $totalVibrationTime s"

            // Mostrar Toast con un mensaje
            Toast.makeText(this, "MEJOR ESTUDIA ADMINISTRACION DE EMPRESAS", Toast.LENGTH_SHORT).show()
        }
    }
}
