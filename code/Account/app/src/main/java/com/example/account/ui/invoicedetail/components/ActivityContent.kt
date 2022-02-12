package com.example.account.ui.invoicedetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.account.model.Invoice
import com.example.account.utils.Constants
import com.example.account.utils.getStatus

@Composable
fun ActivityContent(invoice: Invoice) {
    Column(
        modifier = Modifier
            .padding(
                bottom = Constants.outerPadding,
                start = Constants.outerPadding,
                end = Constants.outerPadding
            )
            .verticalScroll(rememberScrollState())
    ) {
        StatusCard(getStatus(invoice.status))
        DetailCard(invoice)
    }
}