package com.example.account.ui.invoicedetail.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.account.model.Invoice
import com.example.account.model.enums.InvoiceButton
import com.example.account.ui.invoicedetail.components.CustomButton
import com.example.account.viewmodel.InvoiceDetailViewModel

@Composable
fun DeleteDialog(
    invoice: Invoice,
    invoiceDetailViewModel: InvoiceDetailViewModel,
    activity: Activity,
    openDialog: MutableState<Boolean>
) {
    if (openDialog.value) {
        AlertDialog(
            modifier = Modifier.clip(RoundedCornerShape(10.dp)),
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = "Confirm Deletion",
                    fontSize = 22.sp,
                    color = MaterialTheme.colors.onBackground,
                )
            },
            text = {
                Text(
                    text = "Are you sure you want to delete invoice " +
                            "#${invoice.id}? This action cannot be undone.",
                    lineHeight = 20.sp,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSurface,
                )
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(bottom = 30.dp, end = 30.dp, start = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    CustomButton(modifier = Modifier
                        .padding(end = 10.dp)
                        .clip(RoundedCornerShape(90.dp))
                        .clickable {
                            openDialog.value = false
                        })
                    CustomButton(
                        InvoiceButton.Delete,
                        Modifier
                            .clip(RoundedCornerShape(90.dp))
                            .clickable {
                                openDialog.value = false
                                invoiceDetailViewModel.deleteInvoice(invoice)
                                activity.finish()
                            })
                }
            }
        )
    }
}