package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SubHeading(heading: String) {
    Text(
        text = heading,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
    )
}