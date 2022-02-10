package com.example.account.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

class Constants {
    companion object {
        val cardShape = RoundedCornerShape(10.dp)
        val cardPadding = 20.dp
        val outerPadding = 20.dp
        const val paid = "paid"
        const val pending = "pending"
        const val draft = "draft"
    }
}
