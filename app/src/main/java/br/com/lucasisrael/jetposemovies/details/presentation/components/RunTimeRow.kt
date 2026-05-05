package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.utils.time.fromMinutesToHours

@SuppressWarnings("FunctionNaming")
@Composable
fun RunTimeRow(
    runtime: Int?,
    modifier: Modifier,
) {
    val runTimeText = if (runtime == null) {
        stringResource(R.string.field_not_available)
    } else {
        runtime.fromMinutesToHours().toString() + "h"
    }

    Row(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icons8_clock_64),
            contentDescription = stringResource(R.string.clock_icon)
        )
        Text(
            text = runTimeText
        )
    }
}
