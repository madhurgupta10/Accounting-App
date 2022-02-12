package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.model.InvoiceItem
import com.example.account.utils.Constants
import com.example.account.viewmodel.NewInvoiceViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun ActivityContent(
    toggleBottomBar: (value: Boolean) -> Unit,
    newInvoiceViewModel: NewInvoiceViewModel
) {
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val items: MutableList<InvoiceItem> = remember { mutableStateListOf() }
    val invoice: Invoice = newInvoiceViewModel.invoice
    val isNew = newInvoiceViewModel.isNew
    items.addAll(invoice.items)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = Constants.outerPadding,
                start = Constants.outerPadding,
                end = Constants.outerPadding
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = Color.Transparent)
            ) {
                coroutineScope.launch {
                    focusManager.clearFocus()
                    delay(20)
                    toggleBottomBar(true)
                }
            }
    ) {
        item {
            InvoiceDetailInput(invoice = invoice, isNew = isNew, toggleBottomBar = toggleBottomBar)
        }
        if (items.isNotEmpty()) {
            item {
                ItemListHeader("Item List")
            }
        }
        itemsIndexed(items) { _, item ->
            InvoiceItemInput(item, toggleBottomBar, modifier = Modifier
                .clickable {
                    items.remove(item)
                    invoice.items = items
                }
                .animateItemPlacement()
            )
        }
        item {
            AddNewItemButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 150.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .clickable {
                        items.add(InvoiceItem(parentInvoiceId = invoice.id))
                        invoice.items = items
                    }
                    .animateItemPlacement()
            )
        }
    }
}