package com.uvg.lab6
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Contador()
        }
    }
}

@Composable
fun Contador() {
    var counter by remember { mutableIntStateOf(0) }
    var totalIncremento by remember { mutableIntStateOf(0) }
    var totalDisminuir by remember { mutableIntStateOf(0) }
    var valormax by remember { mutableIntStateOf(Int.MIN_VALUE) }
    var valormin by remember { mutableIntStateOf(Int.MAX_VALUE) }
    var totalcam by remember { mutableIntStateOf(0) }
    val historial = remember { mutableStateListOf<Pair<Int, Boolean>>() }

    fun reset() {
        counter = 0
        totalIncremento = 0
        totalDisminuir = 0
        valormax = 0
        valormin = 0
        totalcam = 0
        historial.clear()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Javier Andres Chen Gonzalez", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                counter--
                totalDisminuir++
                totalcam++
                historial.add(counter to false)
                if (counter < valormin) valormin = counter
            }) {
                Text("-", fontSize = 32.sp, color = Color.White, modifier = Modifier.background(Color(0xFF5D67F0)).padding(8.dp))
            }
            Text(text = "$counter", fontSize = 48.sp, modifier = Modifier.padding(horizontal = 32.dp))
            IconButton(onClick = {
                counter++
                totalIncremento++
                totalcam++
                historial.add(counter to true)
                if (counter > valormax) valormax = counter
            }) {
                Text("+", fontSize = 32.sp, color = Color.White, modifier = Modifier.background(Color(0xFF5D67F0)).padding(8.dp))
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Total incrementos: $totalIncremento",fontSize = 28.sp)
            Text("Total decrementos: $totalDisminuir",fontSize = 28.sp)
            Text("Valor máximo: $valormax",fontSize = 28.sp)
            Text("Valor mínimo: $valormin",fontSize = 28.sp)
            Text("Total cambios: $totalcam",fontSize = 28.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Historial:", fontSize = 30.sp, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())

        val listState = rememberLazyListState()

        LazyColumn(state = listState) {
            itemsIndexed(historial.chunked(5)) { index, row ->
                Row {
                    row.forEach { (value, isIncrement) ->
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(4.dp)
                                .background(if (isIncrement) Color(0xFF4CAF50) else Color(0xFFD32F2F)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "$value", color = Color.White,fontSize = 20.sp)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { reset() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Reiniciar")
        }
    }
}
