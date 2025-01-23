package br.com.lucasisrael.jetposemovies.common.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressWarnings("FunctionNaming")
@Composable
fun <T>CustomButton (
    onClick: () -> Unit,
    modifier: Modifier,
    composable: @Composable () -> T,
) {
    Button(
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(6.dp),
        onClick = onClick,
        modifier = modifier
    ) {
        composable()
    }
}
