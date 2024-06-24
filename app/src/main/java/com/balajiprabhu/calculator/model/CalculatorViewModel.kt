package com.balajiprabhu.calculator.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.balajiprabhu.calculator.ui.events.CalculatorActions
import com.balajiprabhu.calculator.ui.events.CalculatorOperation
import com.balajiprabhu.calculator.ui.events.CalculatorState

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(calculatorActions: CalculatorActions) {
        when (calculatorActions) {
            is CalculatorActions.Number -> enterNumber(calculatorActions.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> state = CalculatorState()
            is CalculatorActions.Operation -> enterOperation(calculatorActions.operation)
            is CalculatorActions.Calculate -> calculate()
            is CalculatorActions.ChangeSign -> changeSign()
            is CalculatorActions.Percentage -> calculatePercentage()
            else -> return
        }
    }

    private fun calculatePercentage() {
        if (state.number1.isNotBlank()) {
            state = state.copy(
                number1 = (state.number1.toDouble() / 100).toString()
            )
        }
    }

    private fun changeSign() {
        if (state.number1.isNotBlank()) {
            state = state.copy(
                number1 = (state.number1.toDouble() * -1).toString().replace(".0", "")
            )
        }
    }

    private fun calculate() {
        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            state = when (state.operation) {
                is CalculatorOperation.Add -> state.copy(
                    number1 = (state.number1.toDouble() + state.number2.toDouble()).toString()
                        .replace(".0", ""),
                    number2 = "",
                    operation = null
                )

                is CalculatorOperation.Subtract -> state.copy(
                    number1 = (state.number1.toDouble() - state.number2.toDouble()).toString()
                        .replace(".0", ""),
                    number2 = "",
                    operation = null
                )

                is CalculatorOperation.Multiply -> state.copy(
                    number1 = (state.number1.toDouble() * state.number2.toDouble()).toString()
                        .replace(".0", ""),
                    number2 = "",
                    operation = null
                )

                is CalculatorOperation.Divide -> state.copy(
                    number1 = (state.number1.toDouble() / state.number2.toDouble()).toString()
                        .replace(".0", ""),
                    number2 = "",
                    operation = null
                )

                else -> return
            }
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.number1.contains(".") && !state.number1.endsWith(".")) {
            if (state.operation != null) {
                if (state.number2.isBlank()) {
                    state = state.copy(
                        number2 = "." + state.number2
                    )
                } else {
                    state = state.copy(
                        number2 =  state.number2 + "."
                    )
                }
            } else {
                return
            }
        } else if (state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        state = if (state.number1.length >= 32) {
            return
        } else if (state.operation != null) {
            state.copy(
                number2 = state.number2 + number
            )
        } else if (state.number1 == "0") {
            state.copy(
                number1 = number.toString()
            )
        } else {
            state.copy(
                number1 = state.number1 + number
            )
        }
    }
}