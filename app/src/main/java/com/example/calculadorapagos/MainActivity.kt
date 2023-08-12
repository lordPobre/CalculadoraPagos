package com.example.calculadorapagos

import android.os.Bundle
import android.widget.EditText
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()// Crea un controlador de navegación
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(navController)// Muestra el composable MainScreen cuando el destino de navegación es "main"
                }
                composable("honorarios") {
                    HonorariosScreen(navController)// Muestra el composable HonorariosScreen cuando el destino de navegación es "honorarios"
                }
            }
        }
    }


}


@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(//
            onClick = {
                navController.navigate("honorarios")// Navega a la pantalla de cálculo de honorarios al hacer clic en este botón
            }
        ) {
            Text("Calcular Honorarios") // Navega a la pantalla de cálculo de contrato al hacer clic en este botón
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate("contrato")
            }
        ) {
            Text("Calcular Contrato")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HonorariosScreen(navController: NavHostController) {
    var sueldoBruto by remember { mutableStateOf(0.0) }
    var resultado by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = sueldoBruto.toString(),
            onValueChange = { newValue -> sueldoBruto = newValue.toDoubleOrNull() ?: 0.0 },
            label = { Text("Sueldo Bruto") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)// Campo de entrada para el sueldo bruto
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val empleado = EmpleadoHonorarios(sueldoBruto)// Crea un objeto EmpleadoHonorarios con el sueldo bruto ingresado
                resultado = empleado.calcularLiquido()// Calcula el pago líquido
            }
        ) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Pago Líquido: $resultado")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.popBackStack()// Navega hacia atrás en la pila de navegación, volviendo a la pantalla principal
            }
        ) {
            Text("Volver a la pantalla principal")
        }
    }
}


