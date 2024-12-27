package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.details.models.local.ProductionCompany

@OptIn(ExperimentalLayoutApi::class)
@SuppressWarnings("FunctionNaming")
@Composable
fun ProductionCompanyRow(
    productionCompanies: List<ProductionCompany>,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {

        Text(text = stringResource(R.string.production_companies))

        FlowRow(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            var aaa = ", "
            productionCompanies.mapIndexed { index, element ->
                if (index == productionCompanies.size - 1) aaa = "."
                Text(text = element.name + aaa)
            }

        }
    }

    Spacer(
        modifier = Modifier.padding(bottom = 16.dp)
    )

}
