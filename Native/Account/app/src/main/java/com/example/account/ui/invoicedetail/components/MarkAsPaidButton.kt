package com.example.account.ui.invoicedetail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.model.enums.InvoiceButton
import com.example.account.ui.invoicedetail.components.CustomButton
import com.example.account.viewmodel.InvoiceDetailViewModel

@Composable
fun MarkAsPaidButton(
    invoice: Invoice,
    invoiceDetailViewModel: InvoiceDetailViewModel
) {
    CustomButton(
        InvoiceButton.MarkAsPaid,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                invoiceDetailViewModel.markInvoiceAsPaid(invoice)
            })
}