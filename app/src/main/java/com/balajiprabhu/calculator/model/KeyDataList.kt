package com.balajiprabhu.calculator.model

import com.balajiprabhu.calculator.ui.compose.KeyType

object KeyDataList {
    val keys = listOf<KeyData>(
        KeyData(
            keyType = KeyType.SPECIAL_OPERATOR,
            keyLabel = "AC"
        ),
        KeyData(
            keyType = KeyType.SPECIAL_OPERATOR,
            keyLabel = "+/-"
        ),
        KeyData(
            keyType = KeyType.SPECIAL_OPERATOR,
            keyLabel = "%"
        ),
        KeyData(
            keyType = KeyType.OPERATOR,
            keyLabel = "/"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "7"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "8"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "9"
        ),
        KeyData(
            keyType = KeyType.OPERATOR,
            keyLabel = "x"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "4"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "5"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "6"
        ),
        KeyData(
            keyType = KeyType.OPERATOR,
            keyLabel = "-"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "1"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "2"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "3"
        ),
        KeyData(
            keyType = KeyType.OPERATOR,
            keyLabel = "+"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "0"
        ),
        KeyData(
            keyType = KeyType.NUMBER,
            keyLabel = "."
        ),
        KeyData(
            keyType = KeyType.OPERATOR,
            keyLabel = "="
        )
    )
}