package com.example.calculadorapagos

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val retencion = sueldoBruto * 0.13
        return sueldoBruto - retencion
    }
}
