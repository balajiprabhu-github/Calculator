package com.balajiprabhu.calculator.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Key(
    modifier: Modifier = Modifier,
    keyType: KeyType,
    label: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(getColor(keyType))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = if (keyType == KeyType.SPECIAL_OPERATOR) Color.Black else Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Start
        )
    }
}

fun getColor(buttonType: KeyType): Color {
    return when (buttonType) {
        KeyType.NUMBER -> Color.DarkGray
        KeyType.OPERATOR -> Color(0xFFFFA500)
        KeyType.SPECIAL_OPERATOR -> Color.LightGray
        KeyType.SELECTED_OPERATOR -> Color.White
    }
}