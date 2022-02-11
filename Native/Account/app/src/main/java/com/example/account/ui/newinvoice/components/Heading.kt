package com.example.account.ui.newinvoice.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun Heading(heading: String) {
    Text(
        text = heading,
        fontSize = 22.sp,
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier
    )
}