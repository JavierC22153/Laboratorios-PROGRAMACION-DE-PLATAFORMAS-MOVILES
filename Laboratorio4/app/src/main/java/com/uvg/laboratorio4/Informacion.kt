package com.uvg.laboratorio4

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun informacion() {
    val customGreen = colorResource(id = R.color.customgreen)
    val backgroundImage: Painter = painterResource(id = R.drawable.uvg_logo)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(8.dp, customGreen)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        // Imagen de fondo
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer { alpha = 0.3f }
        )


        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Text(
                text = "Universidad del Valle de Guatemala",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Programación de plataformas móviles, Sección 30",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "INTEGRANTES",
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    Text(text = "Javier Chen", textAlign = TextAlign.Center)
                    Text(text = "Pablo Méndez", textAlign = TextAlign.Center)
                    Text(text = "Paula De León", textAlign = TextAlign.Center)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "CATEDRÁTICO",
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = "Juan Carlos Durini",
                        textAlign = TextAlign.Center
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp) 
            ) {
                Text(
                    text = "Javier Andres Chen Gonzalez",
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Carnet: 22153",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}