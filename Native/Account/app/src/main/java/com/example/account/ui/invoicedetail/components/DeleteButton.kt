package com.example.account.ui.invoicedetail.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.model.enums.InvoiceButton
import com.example.account.ui.shared.CustomButton
import com.example.account.viewmodel.InvoiceDetailViewModel

@Composable
fun DeleteButton(
    invoice: Invoice,
    invoiceDetailViewModel: InvoiceDetailViewModel,
    activity: Activity,
) {
    val openDialog = remember { mutableStateOf(false) }
    DeleteDialog(invoice, invoiceDetailViewModel, activity, openDialog)
    CustomButton(
        InvoiceButton.Delete,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                openDialog.value = true
            })
}