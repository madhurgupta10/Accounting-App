package com.example.account.ui.main.components

import androidx.compose.foundation.background
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

@Composable
fun AddNewButton(modifier: Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(90.dp))
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
