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
import com.example.account.model.Address

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun AddressInput(address: Address, toggleBottomBar: (value: Boolean) -> Unit) {
    Column {
        CustomTextInput(
            header = "Street Address",
            value = address.street,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            CustomTextInput(
                header = "City",
                value = address.city,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 15.dp),
                toggleBottomBar = toggleBottomBar
            )
            CustomTextInput(
                header = "Postal Code",
                value = address.postCode,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 15.dp),
                toggleBottomBar = toggleBottomBar
            )
        }
        CustomTextInput(
            header = "Country",
            value = address.country,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar
        )
    }
}