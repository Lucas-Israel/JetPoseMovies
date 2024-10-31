package br.com.lucasisrael.jetposemovies.common.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressWarnings("FunctionNaming")
object Spacing {

    @Composable
    fun TwoDpSpacer(multiplier: Int = 1) {
        return Spacer(
            modifier = Modifier
                .padding((multiplier * 2).dp)
        )
    }
}