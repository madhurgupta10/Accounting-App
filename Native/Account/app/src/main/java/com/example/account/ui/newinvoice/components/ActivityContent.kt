package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.account.utils.Constants

@Composable
fun ActivityContent() {
    Column(
        modifier = Modifier
            .padding(
                top = 120.dp,
                bottom = Constants.outerPadding,
                start = Constants.outerPadding,
                end = Constants.outerPadding
            )
            .verticalScroll(rememberScrollState())
    ) {
    }
}