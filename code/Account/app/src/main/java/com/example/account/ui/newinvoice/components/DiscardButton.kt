package com.example.account.ui.newinvoice.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.account.model.enums.InvoiceButton
import com.example.account.ui.shared.CustomButton

@Composable
fun DiscardButton(activity: Activity) {
    CustomButton(
        InvoiceButton.Discard,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                activity.finish()
            })
}