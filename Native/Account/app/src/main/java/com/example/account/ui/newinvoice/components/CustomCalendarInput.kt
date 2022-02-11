package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.R
import com.example.account.utils.getInvoiceDate
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState

@Composable
fun CustomCalendarInput(
    header: String,
    value: String,
    modifier: Modifier
) {
    var text by remember { mutableStateOf(value) }
    val dialogState = rememberMaterialDialogState()

    MaterialDialog(
        dialogState = dialogState,
        buttons = {
            positiveButton("Ok")
            negativeButton("Cancel")
        }
    ) {
        datepicker {
            text = getInvoiceDate(it.toString())
        }
    }

    Column(
        modifier
            .padding(bottom = 20.dp)
            .height(IntrinsicSize.Min)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = Color.Transparent)
            ) {
                dialogState.show()
            }
    ) {
        Text(
            text = header,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        Card(
            elevation = 0.dp,
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 13.dp, top = 20.dp, bottom = 20.dp, end = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onBackground,
                )
                Icon(
                    painter = painterResource(R.drawable.ic_icon_calendar), "calendar",
                    tint = MaterialTheme.colors.primary,
                )
            }
        }
    }
}