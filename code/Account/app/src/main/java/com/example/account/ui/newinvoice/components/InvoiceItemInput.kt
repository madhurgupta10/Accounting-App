package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.R
import com.example.account.model.InvoiceItem
import com.example.account.utils.getItemTotal

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun InvoiceItemInput(
    item: InvoiceItem,
    toggleBottomBar: (value: Boolean) -> Unit,
    modifier: Modifier
) {

    var name by rememberSaveable { mutableStateOf(item.name) }

    var qty by rememberSaveable { mutableStateOf(item.quantity) }
    var price by rememberSaveable { mutableStateOf(item.price) }
    var total by rememberSaveable { mutableStateOf(getItemTotal(price, qty)) }

    Column(modifier = Modifier.padding(bottom = 30.dp)) {
        CustomTextInput(
            header = "Item Name",
            value = name,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar,
            onClick = {
                name = it
                item.name = name
            }
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
                        item.quantity = qty
                        total = getItemTotal(price, qty)
                    }
                }
            )
            CustomPriceInput(
                header = "Price",
                value = price,
                modifier = Modifier
                    .weight(1.1f)
                    .padding(start = 10.dp, end = 10.dp),
                toggleBottomBar = toggleBottomBar,
                onChange = {
                    val num =
                        it.replace(",", "")
                            .replaceFirst("^0*", "")
                            .trim()
                            .substringBefore(" ")
                            .toFloatOrNull()
                    if (num != null) {
                        price = num
                        item.price = price
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
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 45.dp, end = 10.dp)
            )
        }
    }
}