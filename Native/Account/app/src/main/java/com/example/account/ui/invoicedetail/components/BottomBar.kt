package com.example.account.ui.invoicedetail.components

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.model.enums.InvoiceStatus
import com.example.account.utils.getStatus
import com.example.account.viewmodel.InvoiceDetailViewModel

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun BottomBar(
    invoice: Invoice,
    invoiceDetailViewModel: InvoiceDetailViewModel,
    activity: Activity
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(color = MaterialTheme.colors.surface)
            .padding(20.dp)
    ) {
        when (getStatus(invoice.status)) {
            InvoiceStatus.Pending -> {
                EditButton(invoice, activity)
                DeleteButton(invoice, invoiceDetailViewModel, activity)
                MarkAsPaidButton(invoice, invoiceDetailViewModel)
            }
            InvoiceStatus.Draft -> {
                EditButton(invoice, activity)
                DeleteButton(invoice, invoiceDetailViewModel, activity)
            }
            else -> {
                DeleteButton(invoice, invoiceDetailViewModel, activity)
            }
        }
    }
}