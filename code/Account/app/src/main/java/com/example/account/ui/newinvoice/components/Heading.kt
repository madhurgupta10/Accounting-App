package com.example.account.ui.newinvoice.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.account.model.Invoice

@Composable
fun Heading(
    heading: String, invoice: Invoice,
    isNew: Boolean,
) {
    var title = heading
    if (!isNew) {
        title = "Edit #${invoice.id}"
    }
    Text(
        text = title,
        fontSize = 22.sp,
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier
    )
}