package com.example.account.ui.invoicedetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.ui.shared.InvoiceId
import com.example.account.utils.getDueDate
import com.example.account.utils.getInvoiceDate

@Composable
fun Body(invoice: Invoice) {
    Column {
        InvoiceId(invoice.id)
        InvoiceTitle(invoice.description)
        Address(invoice.senderAddress)
        Row(
            modifier = Modifier
                .padding(top = 30.dp, bottom = 30.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                SubTitle(title = "Invoice Date", date = getInvoiceDate(invoice.invoiceDate))
                SubTitle(
                    title = "Payment Date",
                    date = getDueDate(invoice.invoiceDate, invoice.paymentTerms)
                )
            }
            Column {
                SubTitle(
                    title = "Bill To",
                    date = invoice.clientName,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Address(invoice.clientAddress)
            }
        }
        SubTitle(title = "Sent to", date = invoice.clientEmail)
        ItemsCard(invoice)
    }
}