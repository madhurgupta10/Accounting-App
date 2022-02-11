package com.example.account.ui.newinvoice.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.account.model.enums.InvoiceButton
import com.example.account.ui.shared.CustomButton

@Composable
fun AddNewItemButton(modifier: Modifier) {
    CustomButton(InvoiceButton.AddNewItem, modifier)
}