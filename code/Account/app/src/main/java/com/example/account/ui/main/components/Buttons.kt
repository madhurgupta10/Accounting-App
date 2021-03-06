package com.example.account.ui.main.components

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Buttons(modifier: Modifier, context: Context) {
    Row(modifier = modifier) {
        FilterButton(
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        AddNewButton(modifier = Modifier.align(Alignment.CenterVertically), context)
    }
}