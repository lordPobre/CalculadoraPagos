package com.example.calculadorapagos

abstract class Empleado(val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}
