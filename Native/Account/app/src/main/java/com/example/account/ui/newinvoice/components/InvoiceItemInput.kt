package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.R
import com.example.account.utils.getItemTotal

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun InvoiceItemInput(toggleBottomBar: (value: Boolean) -> Unit) {

    var qty by rememberSaveable { mutableStateOf(0) }
    var price by rememberSaveable { mutableStateOf(0.0) }
    var total by rememberSaveable { mutableStateOf(getItemTotal(price, qty)) }

    Column(modifier = Modifier.padding(bottom = 30.dp)) {
        CustomTextInput(
            header = "Item Name",
            value = "Banner Design",
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            CustomNumberInput(
                header = "Qty.",
                value = qty,
                modifier = Modifier
                    .weight(0.7f)
                    .padding(end = 10.dp),
                toggleBottomBar = toggleBottomBar,
                onChange = {
                    val num =
                        it.replaceFirst("^0*", "")
                            .trim()
                            .substringBefore(" ")
                            .toIntOrNull()
                    if (num != null) {
                        qty = num
                        total = getItemTotal(price, qty)
                    }
                }
            )
            CustomPriceInput(
                header = "Price",
                value = price,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp),
                toggleBottomBar = toggleBottomBar,
                onChange = {
                    val num =
                        it.replace(",", "")
                            .replaceFirst("^0*", "")
                            .trim()
                            .substringBefore(" ")
                            .toDoubleOrNull()
                    if (num != null) {
                        price = num
                        total = getItemTotal(price, qty)
                    }
                }
            )
            CustomTotal(
                header = "Total",
                value = total,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
            )
            Icon(
                painter = painterResource(R.drawable.ic_icon_delete), "delete",
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 10.dp)
            )
        }
    }
}