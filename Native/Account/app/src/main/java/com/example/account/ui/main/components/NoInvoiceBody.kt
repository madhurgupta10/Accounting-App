package com.example.account.ui.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.account.R

@Composable
fun NoInvoiceBody(modifier: Modifier) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Min)
            .height(IntrinsicSize.Min)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_illustration_empty), "No Invoice",
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(200.dp)
        )
        Text(
            "There is nothing here",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
        )
        Text(
            "Create an invoice by clicking on New button and get started",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 30.dp)
        )
    }
}