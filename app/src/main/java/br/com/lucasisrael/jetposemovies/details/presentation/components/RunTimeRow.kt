package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.utils.types.values.time.fromMinutesToHours

@SuppressWarnings("FunctionNaming")
@Composable
fun RunTimeRow(
    runtime: Int,
    modifier: Modifier
) {

    Row(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icons8_clock_64),
            contentDescription = stringResource(R.string.clock_icon)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = runtime.fromMinutesToHours().toString() + "h"
        )

    }

}
