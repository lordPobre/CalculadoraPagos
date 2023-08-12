package com.example.calculadorapagos

class EmpleadoContrato(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val retencion = sueldoBruto * 0.20
        return sueldoBruto - retencion
    }
}
