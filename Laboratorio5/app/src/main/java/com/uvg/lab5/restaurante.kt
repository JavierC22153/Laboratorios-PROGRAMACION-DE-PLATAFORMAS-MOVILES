package com.uvg.lab5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext

class RestauranteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // Obtener el contexto actual para mostrar Toast y manejar Intents
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFE8F1EF)) // Background color for the entire screen
            .padding(16.dp)
    ) {
        // Header with "Actualización disponible" and "Descargar"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFA7E4FF))
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.reloj),
                contentDescription = "Update Icon",
                tint = Color.Unspecified, // Use this to keep the original color of the SVG
                modifier = Modifier.size(24.dp)) // Adjust size as needed
            Text(text = "Actualización disponible", color = Color.Black, fontSize = 16.sp)
            Text(
                text = "Descargar",
                color = Color(0xFF03A9F4),
                fontSize = 16.sp,
                modifier = Modifier.clickable { openUrl(context, "https://play.google.com/store/apps/details?id=com.whatsapp") } // Handle click
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Date section
        Column {
            Text(text = "Sábado", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "10 de agosto",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFE8F1EF))
                        .border(
                            width = 2.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(2.dp)
                        .height(35.dp) // Ajusta la altura según sea necesario
                ) {
                    Text(
                        text = "Terminar jornada",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center) // Centra el texto dentro de la Box
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Card with task details
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "San Martin",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f) // Occupy available space
                )
                Icon(
                    painter = painterResource(id = R.drawable.direction), // Replace with your icon resource ID
                    contentDescription = "Icon Description",
                    tint = Color.Unspecified, // Use this if you want the icon's original color
                    modifier = Modifier.size(24.dp)
                        .clickable { openUrl(context, "https://www.google.com/maps/dir//San+Mart%C3%ADn+%E2%80%A2+Mont%C3%BAfar,+12+Calle+0-93+Zona+9,+Centro+Comercial+Montufar,+Cdad.+de+Guatemala+01009/@14.5996252,-90.5316864,15.25z/data=!4m18!1m8!3m7!1s0x8589a17d8164d721:0xd80df53230cc463!2zU2FuIE1hcnTDrW4g4oCiIE1vbnTDumZhcg!8m2!3d14.6035547!4d-90.52565!15sChdzYW4gbWFydMOtbiByZXN0YXVyYW50ZSIDiAEBWhkiF3NhbiBtYXJ0w61uIHJlc3RhdXJhbnRlkgEKcmVzdGF1cmFudOABAA!16s%2Fg%2F11cff9b1y!4m8!1m0!1m5!1m1!1s0x8589a17d8164d721:0xd80df53230cc463!2m2!1d-90.52565!2d14.6035547!3e1?entry=ttu") }
                )
            }
            Text(text = "Centro Comercial Montufar, zona 9", fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "6:30AM - 9:00PM", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { showToast(context, "Javier Andres Chen Gonzalez") }, // Show Toast message
                    modifier = Modifier.weight(1f) // Use weight to separate elements
                ) {
                    Text(
                        text = "Iniciar",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.width(16.dp)) // Space between the button and text
                Text(
                    text = "Detalles",
                    color = Color(0xFFFF5722),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { showDetailsToast(context) } // Handle click
                        .align(Alignment.CenterVertically), // Center text vertically
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// Función auxiliar para mostrar un Toast
fun showToast(context: android.content.Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

// Función auxiliar para mostrar el Toast con detalles
fun showDetailsToast(context: android.content.Context) {
    val message = "Pizza\n¿Qué tan caro es?\nBarato: Q10\nNormal: Q20\nCaro: Q30"
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

// Función auxiliar para abrir una URL en el navegador
fun openUrl(context: android.content.Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

// Función para previsualizar la pantalla principal
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}