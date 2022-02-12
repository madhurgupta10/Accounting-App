package com.example.account.ui.invoicedetail.components

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.model.enums.InvoiceButton
import com.example.account.ui.newinvoice.NewInvoiceActivity
import com.example.account.ui.shared.CustomButton

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun EditButton(invoice: Invoice, activity: Activity) {
    CustomButton(
        InvoiceButton.Edit,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                activity.finish()
                val intent = Intent(activity, NewInvoiceActivity::class.java)
                intent.putExtra("invoice", invoice)
                activity.startActivity(intent)
            })
}