package com.example.account.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.account.TopAppBar
import com.example.account.ui.theme.AccountTheme

@Composable
fun ActivityTemplate(
    content: @Composable () -> Unit,
    bottomBar: @Composable (modifier: Modifier) -> Unit = {}
) {
    AccountTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            Box {
                TopAppBar()
                content()
                bottomBar(modifier = Modifier.align(Alignment.BottomCenter))
            }
        }
    }
}

@Composable
fun InvoiceId(id: String) {
    Row {
        Text(
            text = "#",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
        Text(
            text = id,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.onBackground
        )
    }
}