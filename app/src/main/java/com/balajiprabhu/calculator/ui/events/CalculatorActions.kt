package com.balajiprabhu.calculator.ui.events

sealed class CalculatorActions {
    data class Number(val number: Int) : CalculatorActions()
    data object Clear : CalculatorActions()
    data object Decimal : CalculatorActions()
    data object Calculate : CalculatorActions()
    data object ChangeSign : CalculatorActions()
    data object Percentage : CalculatorActions()
    data class Operation(val operation: CalculatorOperation) : CalculatorActions()
    data object InvalidInput : CalculatorActions()
}