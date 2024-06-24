package com.balajiprabhu.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.balajiprabhu.calculator.model.CalculatorViewModel
import com.balajiprabhu.calculator.ui.page.CalculatorPage
import com.balajiprabhu.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    val viewModel = viewModel<CalculatorViewModel>()
                    CalculatorPage(
                        state = viewModel.state,
                        onAction = viewModel::onAction,
                        )
                }
            }
        }
    }
}