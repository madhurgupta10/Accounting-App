package com.example.account.ui.invoicedetail.components

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.ui.shared.GoBack
import com.example.account.utils.Constants
import com.example.account.utils.getStatus

@Composable
fun ActivityContent(activity: Activity, invoice: Invoice) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp)
    ) {
        GoBack(activity)
        Column(
            modifier = Modifier
                .padding(
                    top = 0.dp,
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
}