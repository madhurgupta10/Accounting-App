package com.example.account.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.account.model.enums.InvoiceStatus
import com.example.account.ui.theme.*

@Composable
fun StatusButton(modifier: Modifier, type: InvoiceStatus) {
    var backgroundColor = ColorPaidBackground
    var foregroundColor = ColorPaidForeground
    var text = "Paid"
    when (type) {
        InvoiceStatus.Pending -> {
            backgroundColor = ColorPendingBackground
            foregroundColor = ColorPendingForeground
            text = "Pending"
        }
        InvoiceStatus.Draft -> {
            backgroundColor = ColorDraftBackground
            foregroundColor = ColorDraftForeground
            text = "Draft"
        }
        else -> {}
    }

    Card(
        shape = RoundedCornerShape(6.dp),
        backgroundColor = backgroundColor,
        modifier = modifier
            .width(100.dp),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 10.dp
            ),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .fillMaxHeight()
                    .clip(CircleShape)
                    .background(foregroundColor)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = text,
                fontSize = 12.sp,
                color = foregroundColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 7.dp)
            )
        }
    }
}