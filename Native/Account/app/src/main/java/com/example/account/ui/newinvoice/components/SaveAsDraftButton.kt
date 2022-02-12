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
import com.example.account.viewmodel.NewInvoiceViewModel

@Composable
fun SaveAsDraftButton(activity: Activity, newInvoiceViewModel: NewInvoiceViewModel) {
    CustomButton(
        InvoiceButton.SaveAsDraft,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                newInvoiceViewModel.saveInvoiceAsDraft()
                activity.finish()
            })
}