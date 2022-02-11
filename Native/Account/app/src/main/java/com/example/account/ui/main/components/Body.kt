package com.example.account.ui.main.components

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.utils.Constants

@ExperimentalFoundationApi
@Composable
fun Body(modifier: Modifier, invoices: List<Invoice>?, context: Context) {
    if (invoices?.isNotEmpty() == true) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(Constants.outerPadding),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            items(invoices) { invoice ->
                InvoiceCard(context, invoice, modifier = Modifier.animateItemPlacement())
            }
        }
    } else {
        NoInvoiceBody(modifier)
    }
}