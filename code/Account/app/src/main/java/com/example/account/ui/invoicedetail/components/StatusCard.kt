package com.example.account.ui.invoicedetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.account.model.enums.InvoiceStatus
import com.example.account.ui.shared.StatusButton
import com.example.account.utils.Constants

@Composable
fun StatusCard(status: InvoiceStatus) {
    Card(
        shape = Constants.cardShape,
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .clip(Constants.cardShape)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(Constants.cardPadding),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Status",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                StatusButton(
                    modifier = Modifier,
                    type = status
                )
            }
        }
    }
}