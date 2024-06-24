package com.balajiprabhu.calculator.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.balajiprabhu.calculator.model.KeyData
import com.balajiprabhu.calculator.ui.events.CalculatorActions
import com.balajiprabhu.calculator.ui.events.CalculatorOperation

@Composable
fun KeyPad(
    keyDataList: List<KeyData>,
    onActions: (CalculatorActions) -> Unit
) {
    Column {
        KeyRow(keyDataList.subList(0, 4), onActions)
        KeyRow(keyDataList.subList(4, 8), onActions)
        KeyRow(keyDataList.subList(8, 12), onActions)
        KeyRow(keyDataList.subList(12, 16), onActions)
        KeyRow(keyDataList.subList(16, 19), onActions)
    }
}


@Composable
fun KeyRow(
    keyDataList: List<KeyData>,
    onActions: (CalculatorActions) -> Unit
    ) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly
    ) {
       items(keyDataList) { keyData ->
           val action = getCalculatorActions(keyData.keyLabel)
           if (keyData.keyLabel == "0") {
               Key(
                   modifier = Modifier
                       .width(187.dp)
                       .height(90.dp)
                       .padding(all = 4.dp,),
                   keyType = keyData.keyType,
                   label = keyData.keyLabel,
                   onClick = { onActions(action) }
               )
           } else {
               Key(
                   modifier = Modifier
                       .size(90.dp)
                       .padding(4.dp),
                   keyType = keyData.keyType,
                   label = keyData.keyLabel,
                   onClick = { onActions(action) }
               )
           }

       }
    }
}

fun getCalculatorActions(keyLabel: String): CalculatorActions {
    return when (keyLabel) {
        "AC" -> CalculatorActions.Clear
        "+/-" -> CalculatorActions.ChangeSign
        "%" -> CalculatorActions.Percentage
        "/" -> CalculatorActions.Operation(CalculatorOperation.Divide)
        "x" -> CalculatorActions.Operation(CalculatorOperation.Multiply)
        "-" -> CalculatorActions.Operation(CalculatorOperation.Subtract)
        "+" -> CalculatorActions.Operation(CalculatorOperation.Add)
        "=" -> CalculatorActions.Calculate
        "." -> CalculatorActions.Decimal
        else -> {
            try {
                CalculatorActions.Number(keyLabel.toInt())
            } catch (e: NumberFormatException) {
                CalculatorActions.InvalidInput
            }
        }
    }
}