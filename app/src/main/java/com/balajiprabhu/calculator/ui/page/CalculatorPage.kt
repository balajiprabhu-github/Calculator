package com.balajiprabhu.calculator.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.balajiprabhu.calculator.model.KeyDataList
import com.balajiprabhu.calculator.ui.compose.CalculationText
import com.balajiprabhu.calculator.ui.compose.KeyPad
import com.balajiprabhu.calculator.ui.events.CalculatorActions
import com.balajiprabhu.calculator.ui.events.CalculatorState

@Composable
fun CalculatorPage(
    state: CalculatorState, onAction: (CalculatorActions) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        CalculationText(
            calculationText = state.number1 + (state.operation?.symbol ?: "") + state.number2,
        )
        KeyPad(keyDataList = KeyDataList.keys, onAction)
    }
}