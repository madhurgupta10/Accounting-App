package com.example.account.ui.main.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.R

@Composable
fun FilterButton(modifier: Modifier) {
    Row(modifier = modifier) {
        Text(
            "Filter", color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h3,
        )
        Icon(
            painter = painterResource(R.drawable.ic_icon_arrow_down), "Filter List",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(top = 5.dp, start = 10.dp, end = 20.dp)
                .align(Alignment.CenterVertically)
        )
    }
}