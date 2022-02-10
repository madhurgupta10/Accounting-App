package com.example.account.ui.main.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.R
import com.example.account.ui.newinvoice.NewInvoiceActivity

@Composable
fun AddNewButton(modifier: Modifier, context: Context) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                val intent = Intent(context, NewInvoiceActivity::class.java)
                context.startActivity(intent)
            }
            .background(color = MaterialTheme.colors.primary)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.onPrimary)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_icon_plus),
                    "New",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Text(
                "New", color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp, end = 5.dp)
            )
        }
    }
}
