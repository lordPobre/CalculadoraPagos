package com.example.calculadorapagos

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ContratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato)
    }
    // Función para calcular el pago de contrato
    fun calcularContrato(view: View) {
        val sueldoBrutoEditText = findViewById<EditText>(R.id.sueldoBrutoEditText)
        val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)
        // Función para calcular el pago de contrato
        val sueldoBruto = sueldoBrutoEditText.text.toString().toDoubleOrNull() ?: 0.0
        // Crea un objeto EmpleadoContrato y calcula el pago líquido
        val empleado = EmpleadoContrato(sueldoBruto)
        val resultado = empleado.calcularLiquido()
        // Muestra el resultado en el TextView de resultado
        resultadoTextView.text = "Pago Líquido: $resultado"
    }
    // Función para volver a la pantalla principal
    fun volverPrincipal(view: View) {
        finish()
    }
}


