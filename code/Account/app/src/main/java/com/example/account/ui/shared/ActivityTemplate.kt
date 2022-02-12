package com.example.account.ui.shared

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.account.ui.theme.AccountTheme

@Composable
fun ActivityTemplate(
    content: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit = {},
    showGoBack: Boolean = false,
    activity: Activity? = null
) {
    AccountTheme {
        Scaffold(
            topBar = {
                TopAppBar(showGoBack, activity)
            },
            bottomBar = {
                bottomBar()
            },
            content = {
                content()
            },
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        )
    }
}