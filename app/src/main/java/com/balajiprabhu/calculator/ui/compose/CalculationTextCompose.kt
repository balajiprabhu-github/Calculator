package com.balajiprabhu.calculator.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(backgroundColor = 0xFF000000)
@Composable
fun CalculationText(
    calculationText: String = "0"
) {
    Text(
        text = calculationText,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp,
                horizontal = 4.dp),
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.End,
        overflow = TextOverflow.Clip,
        style = TextStyle(
            fontSize = if (calculationText.length <= 8) 80.sp else 60.sp,
            lineHeight = 80.sp
        ),
    )
}

