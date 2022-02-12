package com.example.account.ui.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun InvoiceHeader(num: Int?) {
    var numInvoice = "No invoices"
    if (num != null && num > 0) {
        numInvoice = if (num > 1) {
            "$num invoices"
        } else {
            "$num invoice"
        }
    }
    Column {
        Text(
            "Invoices",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1
        )
        Text(
            numInvoice, color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4
        )
    }
}