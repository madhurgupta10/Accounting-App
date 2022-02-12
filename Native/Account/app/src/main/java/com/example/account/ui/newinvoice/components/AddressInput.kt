package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun AddressInput(
    street: String,
    city: String,
    postCode: String,
    country: String,
    onClickStreet: (String) -> Unit,
    onClickCity: (String) -> Unit,
    onClickPostCode: (String) -> Unit,
    onClickCountry: (String) -> Unit,
    toggleBottomBar: (value: Boolean) -> Unit
) {
    Column {
        CustomTextInput(
            header = "Street Address",
            value = street,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar,
            onClick = onClickStreet
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            CustomTextInput(
                header = "City",
                value = city,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 15.dp),
                toggleBottomBar = toggleBottomBar,
                onClick = onClickCity
            )
            CustomTextInput(
                header = "Postal Code",
                value = postCode,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 15.dp),
                toggleBottomBar = toggleBottomBar,
                onClick = onClickPostCode
            )
        }
        CustomTextInput(
            header = "Country",
            value = country,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar,
            onClick = onClickCountry
        )
    }
}