package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomTotal(
    header: String,
    value: String,
    modifier: Modifier,
) {
    Column(
        modifier
            .padding(bottom = 20.dp)
            .fillMaxSize()
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
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxSize().padding(top = 15.dp),
                horizontalArrangement = Arrangement.Start,
            ) {
                Text(
                    text = value,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}