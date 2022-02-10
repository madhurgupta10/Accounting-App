package com.example.account.ui.shared

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.account.ui.theme.AccountTheme

@Composable
fun ActivityTemplate(
    content: @Composable () -> Unit,
    bottomBar: @Composable (modifier: Modifier) -> Unit = {},
    showGoBack: Boolean = false,
    activity: Activity? = null
) {
    AccountTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            Box {
                TopAppBar(showGoBack, activity)
                content()
                bottomBar(modifier = Modifier.align(Alignment.BottomCenter))
            }
        }
    }
}